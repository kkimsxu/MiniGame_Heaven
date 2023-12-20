package MainGame;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        Font titleFont = new Font("Arial", Font.BOLD, 32);
        Font gameFont = new Font("Arial", Font.BOLD, 24);

        JPanel Container = new JPanel(new BorderLayout());

        JLabel title = new JLabel("MiniGame Heaven");
        title.setFont(titleFont);
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(title);

        GameButton MarbleGame = new GameButton("MarbleGame", this);
        GameButton MemoryGame = new GameButton("MemoryGame", this);
        GameButton SlidePuzzleBoard = new GameButton("SlidePuzzleBoard", this);
        GameButton Sudoku = new GameButton("Sudoku", this);
        GameButton Tetris = new GameButton("Tetris", this);
        MarbleGame.setFont(gameFont);
        MemoryGame.setFont(gameFont);
        SlidePuzzleBoard.setFont(gameFont);
        Sudoku.setFont(gameFont);
        Tetris.setFont(gameFont);
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        buttonPanel.add(MarbleGame);
        buttonPanel.add(MemoryGame);
        buttonPanel.add(SlidePuzzleBoard);
        buttonPanel.add(Sudoku);
        buttonPanel.add(Tetris);

        Container.add(topPanel, BorderLayout.NORTH);
        Container.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(Container);

        setTitle("MiniGame Heaven");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
