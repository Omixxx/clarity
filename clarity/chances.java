class Snippet {
     public static K chances(HashMap<K, Float> chances){
         int size = chances.size();
         Object[] values = chances.keySet().toArray();
         float[] probs = new float[size];
         float sum = 0;
         for (int i = 0; i < size; i++) {
             probs[i] = chances.get(values[i]);
             sum += probs[i];
         }
         if (sum <= 0) {
             return null;
         }
         float value = Float(sum);
         sum = probs[0];
         for (int i = 0; i < size; i++) {
             if (value < sum) {
                 return (K) values[i];
             }
             sum += probs[i + 1];
         }
         return null;
     }

}