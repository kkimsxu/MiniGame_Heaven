package Tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {
    private Controller controller;
    private Screen screen;

    public Key(Controller c, Screen s) {
        controller = c;
        screen = s;
    }

    public void keyPressed(KeyEvent e) {
        if (controller != null && controller.getBlock() != null) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    controller.getBlock().rotate();
                    break;
                case KeyEvent.VK_RIGHT:
                    controller.getBlock().moveRight();
                    break;
                case KeyEvent.VK_LEFT:
                    controller.getBlock().moveLeft();
                    break;
                case KeyEvent.VK_DOWN:
                    controller.getBlock().moveDown();
                    break;
            }
            screen.repaint();
        }
    }

    public void keyReleased(KeyEvent e) {
        // Optional: Implement if needed
    }

    public void keyTyped(KeyEvent e) {
        // Optional: Implement if needed
    }
}
