class Snippet {
  public void draw(){
      if (lastX != x || lastY != y || lastW != width || lastH != height || lastA != angle || lastScale.x != scale.x || lastScale.y != scale.y || lastOrigin.x != origin.x || lastOrigin.y != origin.y) {
          lastX = x;
          lastY = y;
          lastW = width;
          lastH = height;
          lastA = angle;
          lastScale.x = scale.x;
          lastScale.y = scale.y;
          lastOrigin.x = origin.x;
          lastOrigin.y = origin.y;
          updateMatrix();
      }
  }
}