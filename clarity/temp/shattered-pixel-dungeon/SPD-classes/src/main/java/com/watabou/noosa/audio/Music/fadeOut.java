class Snippet {
      public synchronized void fadeOut(float duration, Callback onComplete){
          if (fadeTotal == -1f) {
              fadeTotal = duration;
              fadeTime = 0f;
          } else {
              fadeTime = (fadeTime / fadeTotal) * duration;
              fadeTotal = duration;
          }
          onFadeOut = onComplete;
      }
}