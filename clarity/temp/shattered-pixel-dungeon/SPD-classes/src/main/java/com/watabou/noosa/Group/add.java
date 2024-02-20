class Snippet {
    public synchronized Gizmo add(Gizmo g){
        if (g.parent == this) {
            return g;
        }
        if (g.parent != null) {
            g.parent.remove(g);
        }
        // Trying to find an empty space for a new member
        for (int i = 0; i < length; i++) {
            if (members.get(i) == null) {
                members.set(i, g);
                g.parent = this;
                return g;
            }
        }
        members.add(g);
        g.parent = this;
        length++;
        return g;
    }
}