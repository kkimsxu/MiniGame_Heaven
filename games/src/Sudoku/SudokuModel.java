package Sudoku;

// Model: 스도쿠 게임 로직
public class SudokuModel {
    private int[][] board;

    public SudokuModel() {
        board = new int[9][9];
        // 여기에 초기 보드 설정 로직을 추가하세요.
    }

    public boolean addNumber(int row, int col, int number) {
        if (isValidPlacement(row, col, number)) {
            board[row][col] = number;
            return true;
        }
        return false;
    }

    private boolean isValidPlacement(int row, int col, int number) {
        // 행, 열, 그리고 3x3 서브 그리드에서 number의 중복을 확인하는 로직을 구현하세요.
        return true; // 예시 코드
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isComplete() {
        // 게임 완료 조건을 검사하는 로직을 구현하세요.
        return false; // 예시 코드
    }
}
