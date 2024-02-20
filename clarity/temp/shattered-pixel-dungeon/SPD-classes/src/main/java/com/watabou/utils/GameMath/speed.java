class Snippet {
      public static float speed(float speed, float acc){
          if (acc != 0) {
              speed += acc * Game.elapsed;
          }
          return speed;
      }
}