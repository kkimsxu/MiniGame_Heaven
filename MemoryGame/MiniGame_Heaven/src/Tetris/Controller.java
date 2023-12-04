package Tetris;

import java.awt.*;
import java.util.Random;

public class Controller {
    private Block block;
    private Screen screen;
    private Random random;

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
    }

    private void createRandomBlock(int[][][] s, Color[] c) {
        int index = random.nextInt(s.length);
        block = new Block(s[index], c[index]);
        block.setPosition(0, 0);
    }

    public Block getCurrentBlock() { return block; }
}
