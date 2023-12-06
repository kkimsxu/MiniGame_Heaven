package MemoryGame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame extends JFrame implements ActionListener {
    private JButton[] buttons;
    private ArrayList<Integer> cardNumbers;
    private boolean[] flipped;
    private int clickedCard1;
    private int clickedCard2;
    private boolean processing;
    private Color[] cardColors;

    public MemoryGame() {
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(4, 4));

        buttons = new JButton[16];
        cardNumbers = new ArrayList<>();
        flipped = new boolean[16];
        clickedCard1 = -1;
        clickedCard2 = -1;
        processing = false;

        // 색상 배열 초기화
        cardColors = new Color[8];
        cardColors[0] = Color.RED;
        cardColors[1] = Color.BLUE;
        cardColors[2] = Color.GREEN;
        cardColors[3] = Color.YELLOW;
        cardColors[4] = Color.ORANGE;
        cardColors[5] = Color.PINK;
        cardColors[6] = Color.CYAN;
        cardColors[7] = Color.MAGENTA;

        // 숫자 카드 랜덤으로 초기화
        for (int i = 0; i < 8; i++) {
            cardNumbers.add(i);
            cardNumbers.add(i);
        }
        Collections.shuffle(cardNumbers);

        // 버튼 생성 및 액션 리스너 추가
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (processing) {
            return;
        }

        for (int i = 0; i < 16; i++) {
            if (e.getSource() == buttons[i] && !flipped[i]) {
                if (clickedCard1 == -1) {
                    clickedCard1 = i;
                    flipped[i] = true;
                    buttons[i].setBackground(cardColors[cardNumbers.get(i)]);
                } else if (clickedCard2 == -1 && i != clickedCard1) {
                    clickedCard2 = i;
                    flipped[i] = true;
                    buttons[i].setBackground(cardColors[cardNumbers.get(i)]);
                    processing = true;
                    Timer timer = new Timer(1000, new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            checkCards();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
                break;
            }
        }
    }

    private void checkCards() {
        if (cardNumbers.get(clickedCard1).equals(cardNumbers.get(clickedCard2))) {
            buttons[clickedCard1].setEnabled(false);
            buttons[clickedCard2].setEnabled(false);
        } else {
            buttons[clickedCard1].setBackground(null);
            buttons[clickedCard2].setBackground(null);
            flipped[clickedCard1] = false;
            flipped[clickedCard2] = false;
        }
        clickedCard1 = -1;
        clickedCard2 = -1;
        processing = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MemoryGame();
            }
        });
    }
}
