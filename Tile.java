public class Tile {
    private boolean isClosed;

    public Tile(){
        this.isClosed = false;
    }

    public boolean isClosed(){
        return isClosed;
    }

    public void setClosed(boolean isClosed){
        this.isClosed = isClosed;
    }

}
