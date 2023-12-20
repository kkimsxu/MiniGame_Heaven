package Tetris;

import javax.swing.*;
import java.awt.*;

public class Block {
    private int[][] shape;
    private int size;
    private Color color;
    private int x, y;
    private int minX, maxX, maxY;

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

    public void setMaxPosition(int minx, int maxx, int y) {
        minX = minx / size;
        maxX = maxx / size;
        maxY = y / size;
    }

    public int getBlockWidth() {
        int maxWidth = 0;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == 1 && j + 1 > maxWidth) {
                    maxWidth = j + 1;
                }
            }
        }
        return maxWidth;
    }

    public int getBlockHeight() {
        int maxHeight = 0;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == 1 && i + 1 > maxHeight) {
                    maxHeight = i + 1;
                }
            }
        }
        return maxHeight;
    }

    public int getLeftSpace() {
        int leftSpace = shape[0].length;
        for (int i = 0; i < shape.length; i++) {
            int currentRowSpace = 0;
            while (currentRowSpace < shape[i].length && shape[i][currentRowSpace] == 0) {
                currentRowSpace++;
            }
            leftSpace = Math.min(leftSpace, currentRowSpace);
        }
        return leftSpace;
    }

    public void moveRight() {
        if ((x + getBlockWidth()) < (690 / size))
        x += 1;
    }

    public void moveLeft() {
        if (x * size - getLeftSpace() * size > 330)
            x -= 1;
    }

    public void moveDown() {
        if ((y + getBlockHeight()) < 660 / size)
            y += 1;
    }

    public int[][] getShape() { return shape; }

    public Color getColor() { return color; }

    public int getX() { return x * size; }

    public int getY() { return y * size; }

    public int getSize() { return size; }
}
