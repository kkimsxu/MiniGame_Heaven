package SlidePuzzleBoard;
import javax.swing.*;
import java.awt.event.*;

public class StartButton extends JButton implements ActionListener {

    private SlidePuzzleBoard board;
    private PuzzleFrame frame;

    public StartButton(SlidePuzzleBoard b, PuzzleFrame f) {
        super("Start");
        board = b;
        frame = f;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        board.createPuzzleBoard();
        frame.startTimer();
        frame.update();
    }
}
