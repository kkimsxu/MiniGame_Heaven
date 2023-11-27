package Sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controller: 모델과 뷰를 연결

public class SudokuController {
    private SudokuModel model;
    private SudokuView view;

    public SudokuController(SudokuModel model, SudokuView view) {
        this.model = model;
        this.view = view;
        view.setNumberListener(new NumberListener());
    }

    class NumberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 숫자 입력 처리 로직
        }
    }

    public void updateView() {
        view.updateBoard(model.getBoard());
    }
}

