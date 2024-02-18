class Snippet {
    public synchronized Gizmo sendToBack(Gizmo g){
        if (members.contains(g)) {
            members.remove(g);
            members.add(0, g);
            return g;
        } else {
            return null;
        }
    }

}