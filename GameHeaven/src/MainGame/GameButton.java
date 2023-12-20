package MainGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MarbleGame.MarbleGame;
import MemoryGame.MemoryGame;
import SlidePuzzleBoard.PuzzleStarter;
import Sudoku.SudokuPuzzle;
import Tetris.Tetris;

public class GameButton extends JButton implements ActionListener {
    private String game;
    private JFrame frame;

    public GameButton(String g, JFrame f) {
        super(g);
        game = g;
        frame = f;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (game.equals("MarbleGame"))
            MarbleGame.startGame();
        else if (game.equals("MemoryGame"))
            MemoryGame.startGame();
        else if (game.equals("SlidePuzzleBoard"))
            PuzzleStarter.startGame();
        else if (game.equals("Sudoku"))
            SudokuPuzzle.startGame();
        else if (game.equals("Tetris"))
            Tetris.startGame();
        frame.dispose();
    }
}
