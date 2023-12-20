package Sudoku;

public class SudokuPuzzle {

	public static void main(String[] args) {
		startGame();
	}

	public static void startGame() {
		new SudokuController().playSudokuPuzzle();
	}
}
