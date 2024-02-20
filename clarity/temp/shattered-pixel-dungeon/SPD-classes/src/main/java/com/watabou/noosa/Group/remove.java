class Snippet {
    public synchronized Gizmo remove(Gizmo g){
        if (members.remove(g)) {
            length--;
            g.parent = null;
            return g;
        } else {
            return null;
        }
    }
}