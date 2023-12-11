package sudokugui;

public class SudokuController {

	private Sudoku sudoku;
	private SudokuWriter writer;

	/** Sudoku, SudokuWriter 객체를 생성하여 필드 변수에 지정한다. */
	public SudokuController() {
		int hole_count = new PlayerInput().selectLevel(); // 난이도 선택
		sudoku = new Sudoku(hole_count);
		writer = new SudokuWriter(sudoku);
	}

	/** 스도쿠 퍼즐 게임을 진행한다. */
	public void playSudokuPuzzle() {
		// 게임이 완료될 때까지 대기
		// SudokuWriter 클래스의 PuzzleButton 내부에서 사용자의 모든 입력이 처리됨
		while (!sudoku.isCompleted()) {
			try {
				Thread.sleep(500); // 주기적으로 게임 상태 확인
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 게임 종료 조건 충족 시 실행될 코드
		System.out.println("축하합니다! 스도쿠를 완성했습니다!");
	}
}
