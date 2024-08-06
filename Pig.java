public class Pig {
    private int x;
    private int y;

    public Pig(int startX, int startY){
        this.x = startX;
        this.y = startY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int newX,int newY) {
        this.x = newX;
        this.y = newY;
    }
}
