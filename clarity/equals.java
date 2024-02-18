class Snippet {
   public boolean equals(Object o){
       return o instanceof GameAction && ((GameAction) o).code == code;
   }

}