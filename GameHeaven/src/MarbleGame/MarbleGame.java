package MarbleGame;


public class MarbleGame {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        Player p = new Player();
        Computer c = new Computer();
        Registrar r = new Registrar();
        new GameController(p, c, r).play();
    }
}