class Snippet {
       public void seed(Level level, int cell, int amount){
           super.seed(level, cell, amount);
           level.solid[cell] = cur[cell] > 0 || (Terrain.flags[level.map[cell]] & Terrain.SOLID) != 0;
           level.flamable[cell] = cur[cell] > 0 || (Terrain.flags[level.map[cell]] & Terrain.FLAMABLE) != 0;
       }

}