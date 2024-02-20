class Snippet {
    private static void killDuplicateKeysInLibGDXJSON(JsonValue val){
        HashSet<String> keys = new HashSet<>();
        while (val != null) {
            if (val.name != null && keys.contains(val.name)) {
                //delete the duplicate key
                val.prev.next = val.next;
                if (val.next != null)
                    val.next.prev = val.prev;
                val.parent.size--;
            } else {
                keys.add(val.name);
                if (val.child != null) {
                    killDuplicateKeysInLibGDXJSON(val.child);
                }
            }
            val = val.next;
        }
    }
}