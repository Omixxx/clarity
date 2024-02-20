class Snippet {
      public static void setMapSize(int width, int height){
          PathFinder.width = width;
          PathFinder.size = width * height;
          distance = new int[size];
          goals = new boolean[size];
          queue = new int[size];
          queued = new boolean[size];
          maxVal = new int[size];
          Arrays.fill(maxVal, Integer.MAX_VALUE);
          dir = new int[] { -1, +1, -width, +width, -width - 1, -width + 1, +width - 1, +width + 1 };
          dirLR = new int[] { -1 - width, -1, -1 + width, -width, +width, +1 - width, +1, +1 + width };
          NEIGHBOURS4 = new int[] { -width, -1, +1, +width };
          NEIGHBOURS8 = new int[] { -width - 1, -width, -width + 1, -1, +1, +width - 1, +width, +width + 1 };
          NEIGHBOURS9 = new int[] { -width - 1, -width, -width + 1, -1, 0, +1, +width - 1, +width, +width + 1 };
          CIRCLE4 = new int[] { -width, +1, +width, -1 };
          CIRCLE8 = new int[] { -width - 1, -width, -width + 1, +1, +width + 1, +width, +width - 1, -1 };
      }
}