class Snippet {
       public void zoom(float value, float fx, float fy){
           PointF offsetAdjust = centerOffset.clone();
           centerOffset.scale(zoom).invScale(value);
           zoom = value;
           width = (int) (screenWidth / zoom);
           height = (int) (screenHeight / zoom);
           snapTo(fx - offsetAdjust.x, fy - offsetAdjust.y);
       }

}