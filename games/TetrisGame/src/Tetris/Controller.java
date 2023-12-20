package Tetris;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Controller {
    private Block block;
    private Screen screen;
    private Random random;
    private Timer timer;
    private int index;

    public Controller(Screen screen) {
        this.screen = screen;
        this.random = new Random();

        int[][][] shapes = {
                {{1, 1}, {1, 1}}, // oShape
                {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}}, // iShape
                {{0, 1, 0}, {1, 1, 1}}, // tShape
                {{1, 0, 0}, {1, 0, 0}, {1, 1, 0}}, // lShape
                {{0, 0, 1}, {0, 0, 1}, {0, 1, 1}}, // jShape
                {{1, 1, 0}, {0, 1, 1}}, // zShape
                {{0, 1, 1}, {1, 1, 0}}  // sShape
        };

        Color[] colors = {
                Color.YELLOW, // o
                Color.CYAN,   // i
                Color.MAGENTA,// t
                Color.ORANGE, // l
                Color.BLUE,   // j
                Color.RED,    // z
                Color.GREEN   // s
        };

        createRandomBlock(shapes, colors);

        screen.repaint();  // 화면 갱신

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (block.getY() + block.getBlockHeight() < 660) {
                    block.moveDown();
                    System.out.println(block.getY());
                    System.out.println(block.getX());
                    screen.repaint();
                }
                else {
                    createRandomBlock(shapes, colors);
                    block.setPosition(16, 2);
                    screen.repaint();
//                    timer.stop();
                }
            }
        });
        timer.start();

        if (block.getY() != 540)
            timer.start();
        else timer.stop();
    }

    private void createRandomBlock(int[][][] s, Color[] c) {
        index = random.nextInt(s.length);
        block = new Block(s[index], c[index]);
        block.setPosition(16, 2);
    }

    public Block getBlock() { return block; }

    public Block getCurrentBlock() { return block; }
}
