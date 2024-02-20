class Snippet {
         public void tint(float r, float g, float b, float strength){
             rm = gm = bm = 1f - strength;
             ra = r * strength;
             ga = g * strength;
             ba = b * strength;
         }
}