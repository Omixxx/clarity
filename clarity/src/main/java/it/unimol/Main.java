/* (C)2024 */
package it.unimol;

import it.unimol.Miner.Miner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  private static final Miner miner = new Miner();
  private static final ConcurrentLinkedQueue<File> queue = new ConcurrentLinkedQueue<>();
  private static final int MAX_THREADS = 2;

  public static void main(String[] args) {
    populateQueue(queue, args);
    startScheduledMining(queue, MAX_THREADS);
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

  private static void startScheduledMining(Queue<File> queue, int maxThreads) {
    ExecutorService executorService = Executors.newFixedThreadPool(maxThreads);

    List<CompletableFuture<Void>> futures = new ArrayList<CompletableFuture<Void>>();

    while (!queue.isEmpty()) {
      if (futures.size() >= maxThreads) {
        continue;
      }

      System.out.println(futures.size() + " " + maxThreads);
      System.out.println("Filling...");

      CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(
          () -> {
            miner.mine(queue.poll());
          }, executorService);

      completableFuture.whenComplete((result, throwable) -> {
        if (throwable == null) {
          System.out.println("Mining completed, removing from list.");
          futures.remove(completableFuture);
        }
        System.out.println("Error: " + throwable.getMessage());
      });

      futures.add(completableFuture);
      futures.forEach(cf -> {
        System.out.println(cf);
      });
    }

    CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    allOf.join();

    executorService.shutdown();
  }
}
