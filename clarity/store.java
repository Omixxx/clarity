class Snippet {
    public static void store(Bundle bundle){
        for (LimitedDrops lim : values()) {
            bundle.put(lim.name(), lim.count);
        }
    }

}