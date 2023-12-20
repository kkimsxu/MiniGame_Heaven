package sudokugui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleButton extends JButton {
    private int row;
    private int col;
    private int number;
    private Sudoku sudoku; // Sudoku 객체 참조

    public PuzzleButton(int row, int col, Sudoku sudoku) {
        this.row = row;
        this.col = col;
        this.number = 0;
        this.sudoku = sudoku;
        setFont(new Font("Arial", Font.BOLD, 20));
        setBorder(createBorder(row, col));

        // 버튼 클릭 리스너 추가
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectNumber();
            }
        });
    }

    // 숫자 선택 대화상자를 표시하고 숫자를 설정하는 메서드
    private void selectNumber() {
        String[] options = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Clear"};
        int n = JOptionPane.showOptionDialog(null, "Choose a number:",
                "Select Number", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if (n >= 0 && n < 9) {
            int digit = n + 1;
            boolean isValid = sudoku.check(digit, row, col);
            sudoku.setNumber(digit, row, col);
            updateButtonDisplay(isValid);
        } else if (n == 9) {
            sudoku.setNumber(0, row, col);
            updateButtonDisplay(true);
        }
    }

    private void updateButtonDisplay(boolean isValid) {
        int number = sudoku.getNumber(row, col);
        setNumber(number);
        setForeground(isValid ? Color.BLACK : Color.RED);
    }

    private Border createBorder(int row, int col) {
        int top = (row % 3 == 0) ? 2 : 1;
        int left = (col % 3 == 0) ? 2 : 1;
        int bottom = (row % 3 == 2) ? 2 : 1;
        int right = (col % 3 == 2) ? 2 : 1;

        return BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK);
    }

    public void setNumber(int number) {
        this.number = number;
        this.setText(number > 0 ? String.valueOf(number) : "");
    }

    public int getNumber() {
        return this.number;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }
}
