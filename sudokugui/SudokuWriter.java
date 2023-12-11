package sudokugui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SudokuWriter extends JPanel {
	private Sudoku sudoku;
	private JButton[][] cells;
	private final int SIZE = 50; // 버튼 크기 조정
	private final int PANEL_SIZE = SIZE * 9;

	public SudokuWriter(Sudoku s) {
		sudoku = s;
		setLayout(new GridLayout(9, 9)); // 9x9 그리드 레이아웃 설정
		initializeCells();
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setTitle("Sudoku");
		frame.setSize(PANEL_SIZE, PANEL_SIZE);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initializeCells() {
		cells = new PuzzleButton[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cells[i][j] = new PuzzleButton(i, j, sudoku);
				// addActionListener가 PuzzleButton 생성자 내에서 이미 처리되고 있음
				add(cells[i][j]);
			}
		}
		updateBoard();
	}

	private void selectNumber(int row, int col) {
		String[] options = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Clear"};
		int n = JOptionPane.showOptionDialog(null, "Choose a number:",
				"Select Number", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, options, options[0]);
		if (n >= 0 && n < 9) { // 숫자 선택
			sudoku.setNumber(n + 1, row, col);
		} else if (n == 9) { // Clear 선택
			sudoku.setNumber(0, row, col);
		}
		updateBoard();
	}

	private void updateBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				((PuzzleButton) cells[i][j]).setNumber(sudoku.getNumber(i, j));
			}
		}
	}


}
