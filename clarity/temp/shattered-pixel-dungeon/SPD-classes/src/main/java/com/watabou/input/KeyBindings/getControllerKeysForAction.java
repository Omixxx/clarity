class Snippet {
    public static ArrayList<Integer> getControllerKeysForAction(GameAction action){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : controllerBindings.keySet()) {
            if (controllerBindings.get(i) == action) {
                result.add(i);
            }
        }
        return result;
    }
}