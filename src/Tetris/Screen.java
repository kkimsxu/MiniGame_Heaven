package Tetris;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    private int WIDTH;
    private int HEIGHT;
    private int GAME_WIDTH;
    private int GAME_HEIGHT;

    public Screen() {
        WIDTH = 1280;
        HEIGHT = 720;
        GAME_WIDTH = 360;
        GAME_HEIGHT = 600;

        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setTitle("Tetris");
        f.setSize(WIDTH, HEIGHT);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.white);
        g.fillRect(325, 35, GAME_WIDTH+10, GAME_HEIGHT+10); // Game Rect
        g.fillRect(780, 40, 200, 130); // Score Rect
        g.fillRect(780, 190, 200, 455); // Next Rect
        g.setColor(Color.black);
        g.fillRect(330, 40, GAME_WIDTH, GAME_HEIGHT); // Game Rect
        g.fillRect(785, 45, 190, 120); // Score Rect
        g.fillRect(785, 195, 190, 445); // Next Rect

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("SCORE", 828, 85);
        g.drawString("NEXT", 840, 235);
    }

    public void drawBlock(Graphics g, Block block) {
        g.setColor(block.getColor());
        int[][] shape = block.getShape();
        for (int i=0; i < shape.length; i++) {
            for (int j=0; j < shape[i].length; j++) {
                if (shape[i][j] == 1) {
                    g.fillRect(
                            block.getX() + j * block.getSize(),
                            block.getY() + i * block.getSize(),
                            block.getSize(),
                            block.getSize()
                    );
                }
            }
        }
    }

    public static void main(String[] args) {
        new Screen();
    }
}
