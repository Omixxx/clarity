class Snippet {
     private static synchronized long scrambleSeed(long seed){
         seed ^= seed >>> 32;
         seed *= 0xbea225f9eb34556dL;
         seed ^= seed >>> 29;
         seed *= 0xbea225f9eb34556dL;
         seed ^= seed >>> 32;
         seed *= 0xbea225f9eb34556dL;
         seed ^= seed >>> 29;
         return seed;
     }

}