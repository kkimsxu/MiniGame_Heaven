package Sudoku;

// Main 클래스: 애플리케이션 실행
public class SudokuApp {
    public static void main(String[] args) {
        SudokuModel model = new SudokuModel();
        SudokuView view = new SudokuView();
        SudokuController controller = new SudokuController(model, view);

        view.display();
    }
}
