class Snippet {
    public synchronized Gizmo addToFront(Gizmo g){
        if (g.parent == this) {
            return g;
        }
        if (g.parent != null) {
            g.parent.remove(g);
        }
        // Trying to find an empty space for a new member
        // starts from the front and never goes over a none-null element
        for (int i = length - 1; i >= 0; i--) {
            if (members.get(i) == null) {
                if (i == 0 || members.get(i - 1) != null) {
                    members.set(i, g);
                    g.parent = this;
                    return g;
                }
            } else {
                break;
            }
        }
        members.add(g);
        g.parent = this;
        length++;
        return g;
    }

}