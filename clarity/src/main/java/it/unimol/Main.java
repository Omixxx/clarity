/* (C)2024 */
package it.unimol;

import java.io.File;

import it.unimol.Miner.Miner;

public class Main {
  private static final Miner miner = new Miner();
  public static void main(String[] args) {
    File file = new File(args[0]);
    miner.mine(file);
  }
}
