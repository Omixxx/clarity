class Snippet {
    public synchronized Gizmo bringToFront(Gizmo g){
        if (members.contains(g)) {
            members.remove(g);
            members.add(g);
            return g;
        } else {
            return null;
        }
    }
}