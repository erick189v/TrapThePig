import javax.swing.*;

public class Game {
    private Grid grid;
    private JFrame frame;
    private Panel panel;

    public Game(int size, int tileSize){
        this.grid = new Grid(size);
        this.frame = new JFrame("Trap The Pig");
        this.panel = new Panel(grid, tileSize);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game(10, 50)); // Example grid size and tile size
    }
}
