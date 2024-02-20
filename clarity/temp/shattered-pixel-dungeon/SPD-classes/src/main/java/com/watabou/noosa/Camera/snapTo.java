class Snippet {
     public void snapTo(float x, float y){
         scroll.set(x - width / 2, y - height / 2).offset(centerOffset);
         panIntensity = 0f;
         followTarget = null;
     }
}