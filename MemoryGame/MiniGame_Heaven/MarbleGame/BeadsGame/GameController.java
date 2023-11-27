package GlassBeadGame;

public class GameController {
    Player player;
    Computer computer;
    Registrar registrar;
    public GameController(Player p, Computer c, Registrar r) {
        player = p;
        computer = c;
        registrar = r;
    }
    public void playerTurn() {
        System.out.println("* 당신의 공격!");

        int m = Math.min(Player.getBeads(), Computer.getBeads());
        String e;

        int pla = registrar.chooseForAttack(m);
        System.out.println("당신은 " + pla + " 개의 구슬을 집었습니다.");

        boolean even = registrar.ChooseEven();
        if (even) {e = "짝";}
        else {e = "홀";}
        System.out.println("당신은 " + e + "을 선택했습니다.");

        System.out.println("컴퓨터가 손을 폅니다... ");

        int com = computer.pickForGuard();
        System.out.println(com + "개의 구슬입니다!");

        if ((com % 2 == 0) && even) {
            System.out.println("당신이 이겼습니다. 구슬 획득! : " + pla);
            player.addBeads(pla);
            computer.removeBeads(pla);
        }
        else if ((com % 2 == 1) && !even) {
            System.out.println("당신이 이겼습니다. 구슬 획득! : " + pla);
            player.addBeads(pla);
            computer.removeBeads(pla);
        }
        else {
            System.out.println("당신이 졌습니다. 구슬 제출! : " + pla);
            player.removeBeads(pla);
            computer.addBeads(pla);
        }
    }

    public void computerTurn() {
        System.out.println("* 컴퓨터의 공격!");

        int m = Player.getBeads();
        String e;

        int pla = registrar.chooseForGuard(m);
        System.out.println("당신은 " + pla + " 개의 구슬을 집었습니다.");

        int com = computer.pickForAttack();
        System.out.println("컴퓨터가 " + com + "개의 구슬을 집어듭니다...");

        boolean even = computer.pickEven();
        if (even) {e = "짝";}
        else {e = "홀";}
        System.out.println("컴퓨터가 " + e + "을 선택합니다...");

        if ((com % 2 == 0) && even) {
            System.out.println("당신이 졌습니다. 구슬 제출! : " + com);
            player.removeBeads(com);
            computer.addBeads(com);
        }
        else if ((com % 2 == 1) && !even) {
            System.out.println("당신이 졌습니다. 구슬 제출! : " + com);
            player.removeBeads(com);
            computer.addBeads(com);
        }
        else {
            System.out.println("당신이 이겼습니다. 구슬 획득! : " + com);
            player.addBeads(com);
            computer.removeBeads(com);
        }
    }

    public void play() {
        System.out.println("* 게임을 시작합니다. . .");
        System.out.println();

        while (Player.getBeads() > 0 && Computer.getBeads() > 0) {
            System.out.println("당신의 구슬: " + Player.getBeads());
            System.out.println("컴퓨터의 구슬: " + Computer.getBeads());
            System.out.println();

            playerTurn();

            if ((Player.getBeads() == 0) || (Computer.getBeads() == 0)) break;

            System.out.println("당신의 구슬: " + Player.getBeads());
            System.out.println("컴퓨터의 구슬: " + Computer.getBeads());
            System.out.println();

            computerTurn();
        }

        System.out.println("당신의 구슬: " + Player.getBeads());
        System.out.println("컴퓨터의 구슬: " + Computer.getBeads());

        if (Computer.getBeads() == 0) {
            System.out.println("축하합니다! 당신의 승리입니다!");
        }
        else {
            System.out.println("ㅠㅠ 컴퓨터의 승리입니다...");
        }
    }
}
