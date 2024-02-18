class Snippet {
    public static synchronized void updateAll(){
        int length = all.size();
        for (int i = 0; i < length; i++) {
            Camera c = all.get(i);
            if (c != null && c.exists && c.active) {
                c.update();
            }
        }
    }

}