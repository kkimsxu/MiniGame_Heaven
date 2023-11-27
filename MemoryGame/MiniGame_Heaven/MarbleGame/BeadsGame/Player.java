package GlassBeadGame;

public class Player {
    static private int beads;

    public Player() {
        beads = 10;
    }

    public void addBeads(int n) {
        beads += n;
    }
    public void removeBeads(int n) {
        beads -= n;
    }

    public static int getBeads() {
        return beads;
    }

    public boolean lose() {
        //구슬이 없으면 패배, 패배=false, 승리=true
        //구슬 == 0 이면 true
        return (beads == 0);
    }

}
