class Snippet {
    public static LinkedHashMap<Integer, GameAction> getControllerDefaults(){
        return new LinkedHashMap<>(defaultControllerBindings);
    }
}