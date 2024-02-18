class Snippet {
    public synchronized void updateMapCell(int cell){
        updated.union(cell % mapWidth, cell / mapWidth);
    }

}