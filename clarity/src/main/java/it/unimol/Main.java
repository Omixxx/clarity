/* (C)2024 */
package it.unimol;

import it.unimol.Miner.Miner;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
  private static final Miner miner = new Miner();
  private static final Queue<File> queue = new LinkedList<>();

  public static void main(String[] args) {
    populateQueue(queue, args);
    startScheduledMining(queue, 2);
  }

  private static void populateQueue(Queue<File> queue, String[] args) {
    for (String arg : args) {
      File file = new File(arg);
      queue.add(file);
    }
  }

  @SuppressWarnings("static-access")
  private static void startScheduledMining(Queue<File> queue, int maxThreads) {
    AtomicInteger currentThreads = new AtomicInteger(0);
    CompletableFuture<Void> future = new CompletableFuture<>();

    while (!queue.isEmpty() && currentThreads.get() < maxThreads) {
      currentThreads.incrementAndGet();
      future.runAsync(() -> {
        miner.mine(queue.poll());
      })
          .thenRun(currentThreads::decrementAndGet);
    }
    future.join();
  }
}
