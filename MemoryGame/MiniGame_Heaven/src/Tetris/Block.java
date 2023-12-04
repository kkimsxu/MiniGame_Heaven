package Tetris;

import javax.swing.*;
import java.awt.*;

public class Block {
    private int[][] shape;
    private int size;
    private Color color;
    int x, y;

    public Block(int[][] shape, Color color) {
        size = 30;
        this.shape = shape;
        this.color = color;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void rotate() {
        int[][] rotatedShape = new int[shape[0].length][shape.length];
        for (int i=0; i< shape.length; i++) {
            for (int j=0; j < shape[i].length; j++) {
                rotatedShape[j][shape.length - 1 - i] = shape[i][j];
            }
        }
        shape = rotatedShape;
    }

    public void moveRight() {
        x += 1;
    }

    public void moveLeft() { x -= 1; }

    public void moveDown() { y += 1; }

    public int[][] getShape() { return shape; }

    public Color getColor() { return color; }

    public int getX() { return x * size; }

    public int getY() { return y * size; }

    public int getSize() { return size; }
}
