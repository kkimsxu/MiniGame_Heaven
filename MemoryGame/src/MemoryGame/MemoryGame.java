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
    private ImageIcon[] cardImages; // 이미지 배열 추가

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

        // 이미지 배열 초기화
        cardImages = new ImageIcon[8];
        cardImages[0] = resizeImageIcon(new ImageIcon("src/image1.jpg"));
        cardImages[1] = resizeImageIcon(new ImageIcon("src/image2.jpg"));
        cardImages[2] = resizeImageIcon(new ImageIcon("src/image3.jpg"));
        cardImages[3] = resizeImageIcon(new ImageIcon("src/image4.jpg"));
        cardImages[4] = resizeImageIcon(new ImageIcon("src/image5.jpg"));
        cardImages[5] = resizeImageIcon(new ImageIcon("src/image6.jpg"));
        cardImages[6] = resizeImageIcon(new ImageIcon("src/image7.jpg"));
        cardImages[7] = resizeImageIcon(new ImageIcon("src/image8.jpg"));
        // 나머지 이미지도 동일하게 추가

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
                    buttons[i].setIcon(cardImages[cardNumbers.get(i)]); // 이미지 설정
                } else if (clickedCard2 == -1 && i != clickedCard1) {
                    clickedCard2 = i;
                    flipped[i] = true;
                    buttons[i].setIcon(cardImages[cardNumbers.get(i)]); // 이미지 설정
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
            buttons[clickedCard1].setIcon(null); // 이미지 제거
            buttons[clickedCard2].setIcon(null); // 이미지 제거
            flipped[clickedCard1] = false;
            flipped[clickedCard2] = false;
        }
        clickedCard1 = -1;
        clickedCard2 = -1;
        processing = false;
    }

    private ImageIcon resizeImageIcon(ImageIcon icon) {
        int width = 100; // 원하는 너비
        int height = 100; // 원하는 높이

        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MemoryGame();
            }
        });
    }
}
