class Snippet {
   public static Point windowResolution(){
       return new Point(getInt(KEY_WINDOW_WIDTH, 800, 720, Integer.MAX_VALUE), getInt(KEY_WINDOW_HEIGHT, 600, 400, Integer.MAX_VALUE));
   }

}