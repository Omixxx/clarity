/* (C)2024 */
package it.unimol;

import io.github.cdimascio.dotenv.Dotenv;
import it.unimol.Miner.Miner;
import java.io.File;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
  private static final Logger LOGGER = LoggerFactory.getLogger(Miner.class);

  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.configure()
        .directory("assets")
        .ignoreIfMalformed()
        .ignoreIfMissing()
        .filename("env")
        .load();

    final int MAX_THREADS = Integer.valueOf(dotenv.get("MAX_THREADS", "3"));
    final int BEST_PERCENTAGE = Integer.valueOf(dotenv.get("PERCENTAGE_OF_THE_MOST_READABLE", "20"));
    final int WORST_PERCENTAGE = Integer.valueOf(dotenv.get("PERCENTAGE_OF_THE_WORST_READABLE", "20"));

    assert MAX_THREADS > 0 : "MAX_THREADS must be greater than 0";
    assert BEST_PERCENTAGE > 0 : "BEST_PERCENTAGE must be greater than 0";
    assert WORST_PERCENTAGE > 0 : "WORST_PERCENTAGE must be greater than 0";

    ConcurrentLinkedQueue<File> queue = new ConcurrentLinkedQueue<>();

    populateQueue(queue, args);
    startScheduledAsyncMining(queue, MAX_THREADS);
    Miner miner = new Miner();
    miner.resultFilter(BEST_PERCENTAGE, WORST_PERCENTAGE);
    LOGGER.info("Work done!✨");
  }

  private static void populateQueue(Queue<File> queue, String[] args) {
    assert args.length == 1 : "Usage: java -jar <jarfile> <path/to/repos>";
    File projectsDir = new File(args[0]);
    for (File file : projectsDir.listFiles()) {
      if (file.isDirectory()) {
        queue.add(file);
      }
    }
  }

  private static void startScheduledAsyncMining(Queue<File> queue,
      int maxThreads) {
    ExecutorService executorService = Executors.newFixedThreadPool(maxThreads);
    List<CompletableFuture<Void>> futures = new CopyOnWriteArrayList<>();

    while (!queue.isEmpty()) {
      if (futures.size() >= maxThreads) {
        continue;
      }

      CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
        LOGGER.info("Start async mining");
        Miner miner = new Miner();
        miner.mine(queue.poll());
      }, executorService);

      completableFuture.whenComplete((result, throwable) -> {
        if (throwable == null) {
          LOGGER.info("Mine completed, cleaning future list");
          futures.removeIf(cf -> cf.isDone() || cf.isCompletedExceptionally());
        }
        LOGGER.error("Error: " + throwable.getMessage());
      });
      futures.add(completableFuture);
    }
    LOGGER.info(
        "No more projects to mine, waiting for all futures to complete.");
    CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    allOf.join();
    executorService.shutdown();
  }
}
