class Snippet {
    public synchronized Gizmo addToBack(Gizmo g){
        if (g.parent == this) {
            sendToBack(g);
            return g;
        }
        if (g.parent != null) {
            g.parent.remove(g);
        }
        if (!members.isEmpty() && members.get(0) == null) {
            members.set(0, g);
            g.parent = this;
            return g;
        }
        members.add(0, g);
        g.parent = this;
        length++;
        return g;
    }

}