import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.GridLayout;

public class Panel extends JPanel {
    private Grid grid;
    private int tileSize;

    public Panel(Grid grid, int tileSize){
        this.grid = grid;
        this.tileSize = tileSize;

        this.setPreferredSize(new Dimension(grid.getSize() * tileSize, grid.getSize() * tileSize));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / tileSize;
                int y = e.getY() / tileSize;

                //moving the pig, goal:
                // Allow the pig to move to an adjacent tile when a user clicks on a tile.
                //Ensure the pig does not move to a closed tile.
                //Implement logic to check if the pig has reached the goal (exit)

                // Moving the pig only if the clicked tile is adjacent and not closed

                if(!grid.isClosed(x,y) && !(x == grid.getPig().getX() && y == grid.getPig().getY())){
                    grid.setClosed(x,y);//check grid method.
                    repaint();

                    movePig();
                }
            }
        });
    }

    public void movePig(){
        Pig pig = grid.getPig();
        int pigX =pig.getX();
        int pigY = pig.getY();

        int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, }; //moves right left down up.

        boolean moved = false;
        for(int [] direction : directions){
            int newX = pigX + direction[0];
            int newY = pigY + direction[1];

            if(newX >= 0 && newY >= 0 && newX < grid.getSize() && newY < grid.getSize() && !grid.isClosed(newX, newY)){
                grid.movePig(newX,newY);
                moved = true;
                break;
            }
        }
        repaint();

        if(!moved){
            JOptionPane.showMessageDialog(null,"the pig is trapped");

        }
        if(pig.getX()==0 || pig.getY()==0 || pig.getX() == grid.getSize() -1 || pig.getY() == grid.getSize() -1){
            JOptionPane.showMessageDialog(null,"pig ESCAPED!");
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                if (grid.isClosed(i, j)) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
                g.setColor(Color.GRAY);
                g.drawRect(i * tileSize, j * tileSize, tileSize, tileSize);
            }
        }
        Pig pig = grid.getPig();
        g.setColor(Color.RED);
        g.fillOval(pig.getX() * tileSize, pig.getY() * tileSize, tileSize, tileSize);
    }
}

