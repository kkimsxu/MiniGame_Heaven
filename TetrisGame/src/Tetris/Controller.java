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

    public Controller(Screen screen) {
        this.screen = screen;
        this.random = new Random();

            // 블록 초기화 (예시)
        this.block = new Block(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}}, Color.CYAN);
        this.block.setPosition(5, 5);  // 초기 위치 설정

        screen.repaint();  // 화면 갱신

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                block.moveDown();
                screen.repaint();
            }
        });
        timer.start();

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
    }

    private void createRandomBlock(int[][][] s, Color[] c) {
        int index = random.nextInt(s.length);
        block = new Block(s[index], c[index]);
        block.setPosition(0, 0);
    }

    public Block getBlock() { return block; }

    public Block getCurrentBlock() { return block; }
}
