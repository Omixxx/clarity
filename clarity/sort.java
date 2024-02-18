class Snippet {
    public synchronized void sort(Comparator c){
        //only sort if we aren't already sorted
        for (int i = 0; i < length - 1; i++) {
            if (c.compare(members.get(i), members.get(i + 1)) > 0) {
                Collections.sort(members, c);
                return;
            }
        }
    }

}