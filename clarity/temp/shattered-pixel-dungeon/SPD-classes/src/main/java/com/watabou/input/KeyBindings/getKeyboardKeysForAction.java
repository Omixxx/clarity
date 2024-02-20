class Snippet {
    public static ArrayList<Integer> getKeyboardKeysForAction(GameAction action){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : bindings.keySet()) {
            if (bindings.get(i) == action) {
                result.add(i);
            }
        }
        return result;
    }
}