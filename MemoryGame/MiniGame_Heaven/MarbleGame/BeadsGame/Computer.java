package GlassBeadGame;

public class Computer {
    static private int beads;

    public Computer() { beads = 10;}

    public void addBeads(int n) {
        beads += n;
    }
    public void removeBeads(int n) { beads -= n;}

    public static int getBeads() {return beads;}

    public boolean lose() {
        return (beads == 0);
    }

    public int pickForAttack() {
        if (beads < 5) {
            return ((int)(Math.random() * beads) + 1);
        }
        else {return ((int)(Math.random() * 5) + 1);}
    }

    public int pickForGuard() {
            if (beads < 5) {
                return ((int)(Math.random() * beads));
            }
            else {
                return ((int) (Math.random() * 5));
            }
    }

    public boolean pickEven() {
        //true는 짝수, false는 홀수
        //1이 true, 0이 false
        int q = (int)(Math.random() * 1);

        if (q == 1) {return true;} //짝수
        else {return false;} //홀수
        }
}
