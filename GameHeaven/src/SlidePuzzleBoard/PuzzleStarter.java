package SlidePuzzleBoard;

public class PuzzleStarter {

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        new PuzzleFrame(new SlidePuzzleBoard());
    }
}