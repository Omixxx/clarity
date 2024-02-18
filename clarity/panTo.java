class Snippet {
     public void panTo(PointF dst, float intensity){
         panTarget = dst.offset(centerOffset);
         panIntensity = intensity;
         followTarget = null;
     }

}