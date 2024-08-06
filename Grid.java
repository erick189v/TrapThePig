public class Grid {
    private Tile[][] tiles;
    private Pig pig;
    private int size;

    public Grid(int size){
        this.size = size;
        this.tiles = new Tile[size][size];
        for (int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                tiles[i][j] = new Tile();
            }
        }
        this.pig = new Pig(size/2, size/2);
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Pig getPig() {
        return pig;
    }

    public boolean isClosed(int x, int y){
        return tiles[x][y].isClosed();
    }
    public void setClosed(int x, int y){
        tiles[x][y].setClosed(true);
    }

    public int getSize(){
        return size;
    }

    public void movePig(int x, int y){
        pig.move(x,y);
    }
}

