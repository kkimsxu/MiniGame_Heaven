
public class SudokuController {
	
	private Sudoku sudoku;
	private PlayerInput reader;
	private SudokuWriter writer;
	
	/** Sudoku, PlayerInput, SudokuWriter 객체를 생성하여 필드 변수에 지정한다. */
	public SudokuController() {
		reader = new PlayerInput();
		int hole_count = reader.selectLevel();
		sudoku = new Sudoku(hole_count);
		writer = new SudokuWriter(sudoku);
	}
	
	/** 스도쿠 퍼즐 게임을 진행한다. */
	public void playSudokuPuzzle() {
		int row, col, digit;
		while (sudoku.countHoles() > 0) {
			row = reader.selectNumber("가로줄 번호를 넣어주세요.") - 1;
			col = reader.selectNumber("세로줄 번호를 넣어주세요.") - 1;
			digit = reader.selectNumber("숫자를 넣어주세요.");

			sudoku.check(digit, row, col); // 여기서 숫자가 정답이든 아니든 저장
			writer.repaint(); // 보드 갱신
		}
	}

}
