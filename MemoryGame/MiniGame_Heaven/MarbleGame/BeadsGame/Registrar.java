package GlassBeadGame;

import javax.swing.*;

public class Registrar {


    public boolean ChooseEven() {
        String input = JOptionPane.showInputDialog("홀/짝을 입력하세요.");
        input = input.trim();
        while (!input.equals("홀") && !input.equals("짝")) {
            String input0 = JOptionPane.showInputDialog("홀/짝을 입력하세요.");
            input = input0.trim();
        }
        // 짝이 true, 홀이 false
        if (input.equals("짝")) return true;
        else return false;
    }

    public int chooseForAttack(int max) {
        String input = JOptionPane.showInputDialog("공격: 구슬의 수를 입력하세요. (최소 1)");
        int x  = Integer.parseInt(input);
        while(x > max || x > 5 || x < 1) {
            input = JOptionPane.showInputDialog("공격: 구슬의 수를 입력하세요. (최소 1)");
            x = Integer.parseInt(input);
        }
        return x;
    }

    public int chooseForGuard(int max) {
        String input = JOptionPane.showInputDialog("방어: 구슬의 수를 입력하세요. (최소 0)");
        int y = Integer.parseInt(input);
        while(y > max || y > 5 || y < 0) {
            input = JOptionPane.showInputDialog("방어: 구슬의 수를 입력하세요. (최소 0)");
            y = Integer.parseInt(input);
        }
        return y;
    }
}
