class Snippet {
  public void update(){
      super.update();
      float deadX = 0;
      float deadY = 0;
      if (followTarget != null) {
          panTarget = followTarget.center().offset(centerOffset);
          deadX = width * followDeadzone / 2f;
          deadY = height * followDeadzone / 2f;
      }
      if (panIntensity > 0f) {
          PointF panMove = new PointF();
          panMove.x = panTarget.x - (scroll.x + width / 2f);
          panMove.y = panTarget.y - (scroll.y + height / 2f);
          if (panMove.x > deadX) {
              panMove.x -= deadX;
          } else if (panMove.x < -deadX) {
              panMove.x += deadX;
          } else {
              panMove.x = 0;
          }
          if (panMove.y > deadY) {
              panMove.y -= deadY;
          } else if (panMove.y < -deadY) {
              panMove.y += deadY;
          } else {
              panMove.y = 0;
          }
          panMove.scale(Math.min(1f, Game.elapsed * panIntensity));
          scroll.offset(panMove);
      }
      if ((shakeTime -= Game.elapsed) > 0) {
          float damping = shakeTime / shakeDuration;
          shakeX = Random.Float(-shakeMagX, +shakeMagX) * damping;
          shakeY = Random.Float(-shakeMagY, +shakeMagY) * damping;
      } else {
          shakeX = 0;
          shakeY = 0;
      }
      updateMatrix();
  }
}