package Sudoku;

import java.awt.*;
import javax.swing.*;

public class SudokuWriter extends JPanel {
	
	private Sudoku sudoku; 
	private final int SIZE = 40;
	private final int PANEL_SIZE = SIZE * 11;
	
	/** JPanel 객체 초기화 메소드 
	 *    
	 * @param s - 윈도우에 그릴 Sudoku 객체 
	 */
	public SudokuWriter(Sudoku s) {
		sudoku = s;
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setLocation(160, 200);
		f.setTitle("Sudoku");
		f.setSize(PANEL_SIZE, PANEL_SIZE+28);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; // Graphics 객체를 Graphics2D로 캐스팅
		g.setColor(Color.white);
		g.fillRect(0, 0, PANEL_SIZE, PANEL_SIZE);
		int digit;
		int x = SIZE;
		int y = SIZE;
// 숫자 그리기
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				digit = sudoku.getPuzzleBoard()[i][j];
				if (digit > 0) {
					g2.setColor(Color.black); // 정답인 경우 검은색
					g2.drawString(Integer.toString(digit), SIZE * (i + 1) + 15, SIZE * (j + 1) + 25);
				} else if (digit < 0) {
					g2.setColor(Color.red); // 정답이 아닌 경우 빨간색
					g2.drawString(Integer.toString(-digit), SIZE * (i + 1) + 15, SIZE * (j + 1) + 25);
				}
			}
		}


		x = SIZE; 
		y = SIZE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				g.setColor(Color.black);
				g.drawRect(x, y, SIZE*3, SIZE*3);
				x += SIZE * 3;
			}
			x = SIZE;
			y += SIZE * 3;
		}
		x = SIZE - 25; 
		y = SIZE;
		for (int i = 1; i <= 9; i++) {
			g.setColor(Color.blue);
			g.drawString(i + "", x, y+25);
			y += SIZE;
		}
		x = SIZE; 
		y = SIZE - 10;
		for (int i = 1; i <= 9; i++) {
			g.setColor(Color.blue);
			g.drawString(i + "", x+15, y);
			x += SIZE;
		}
		// 기본 9x9 그리드 그리기
		g2.setStroke(new BasicStroke(1)); // 일반 그리드 선의 두께
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				g2.drawRect(SIZE * (i + 1), SIZE * (j + 1), SIZE, SIZE);
			}
		}

		// 3x3 구역에 두꺼운 선 그리기
		g2.setStroke(new BasicStroke(2)); // 두꺼운 구역 구분 선의 두께
		for (int i = 0; i <= 9; i += 3) {
			g2.drawRect(SIZE * (i + 1), SIZE, SIZE * 3, SIZE * 9);
			g2.drawRect(SIZE, SIZE * (i + 1), SIZE * 9, SIZE * 3);
		}
	}

}
