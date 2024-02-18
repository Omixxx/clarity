class Snippet {
    public synchronized Gizmo erase(Gizmo g){
        int index = members.indexOf(g);
        if (index != -1) {
            members.set(index, null);
            g.parent = null;
            return g;
        } else {
            return null;
        }
    }

}