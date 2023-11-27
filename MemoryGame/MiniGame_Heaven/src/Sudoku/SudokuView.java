package Sudoku;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

// View: GUI 인터페이스

public class SudokuView {
    private JFrame frame;
    private JTextField[][] grid;

    public SudokuView() {
        frame = new JFrame("스도쿠");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        grid = new JTextField[9][9];
        JPanel panel = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new JTextField();
                panel.add(grid[i][j]);
            }
        }
        frame.add(panel);
    }

    public void setNumberListener(ActionListener listener) {
        // 각 JTextField에 대한 리스너 설정
    }

    public void updateBoard(int[][] board) {
        // 보드 업데이트 로직
    }

    public void display() {
        frame.setVisible(true);
    }
}
