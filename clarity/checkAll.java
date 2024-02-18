class Snippet {
   public static ArrayList<Info> checkAll(){
       ArrayList<Info> result = new ArrayList<>();
       for (int i = 1; i <= MAX_SLOTS; i++) {
           Info curr = check(i);
           if (curr != null)
               result.add(curr);
       }
       Collections.sort(result, scoreComparator);
       return result;
   }

}