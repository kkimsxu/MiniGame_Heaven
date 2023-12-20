package _week3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PuzzleButton extends JButton implements ActionListener {
    private SlidePuzzleBoard board;
    private PuzzleFrame frame;
    private int row, col;

    public PuzzleButton(SlidePuzzleBoard b, PuzzleFrame f, int row, int col) {
        this.board = b;
        this.frame = f;
        this.row = row;
        this.col = col;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (board.on()) {
            if (board.move(row, col)) {
                frame.update();
                if (board.gameOver()) {
                    frame.finish();
                }
            }
        }
    }
}




