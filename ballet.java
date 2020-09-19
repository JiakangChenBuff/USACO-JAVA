import java.util.*;
public class ballet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int minX = 0;
        int maxX = 1;
        int minY = 0;
        int maxY = 1;
        boolean failed = false;

        Feet[] bessie = { new Feet(0, 0), new Feet(0, 1), new Feet(1, 0), new Feet(1, 1) };
        int[][] moves = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int dir = 0;

        for (int i = 0; i < N; i++) {
            String instruction = sc.next();
            int foot = map(instruction.substring(0, 2));
            String ins = instruction.substring(2);
            if (ins.equals("F")) {
                bessie[foot].x += moves[dir][0];
                bessie[foot].y += moves[dir][1];
            } else if (ins.equals("B")) {
                bessie[foot].x -= moves[dir][0];
                bessie[foot].y -= moves[dir][1];
            } else if (ins.equals("R")) {
                bessie[foot].x += moves[(dir + 1) % 4][0];
                bessie[foot].y += moves[(dir + 1) % 4][1];
            } else if (ins.equals("L")) {
                bessie[foot].x -= moves[(dir + 1) % 4][0];
                bessie[foot].y -= moves[(dir + 1) % 4][1];
            } else {
                dir = (dir + 1) % 4;

                for (int j = 0; j < 4; j++) {
                    if (j != foot) {
                        bessie[j].x -= bessie[foot].x;
                        bessie[j].y -= bessie[foot].y;
                        int tmpX = bessie[j].x;
                        bessie[j].x = bessie[j].y;
                        bessie[j].y = -1 * tmpX;
                        bessie[j].x += bessie[foot].x;
                        bessie[j].y += bessie[foot].y;
                    }
                }
            }
            for (int j = 0; j < 4; j++) {
                for (int k = j + 1; k < 4; k++) {
                    if (bessie[j].samePlace(bessie[k])) {
                        failed = true;
                        break;
                    }
                }
            }
            for (int j = 0; j < 4; j++) {
                minX = Math.min(minX, bessie[j].x);
                maxX = Math.max(maxX, bessie[j].x);
                minY = Math.min(minY, bessie[j].y);
                maxY = Math.max(maxY, bessie[j].y);
            }
        }

        if (failed) {
            System.out.println(-1);
        } else {
            System.out.println((maxX - minX + 1) * (maxY - minY + 1));
        }
        sc.close();
    }

    public static int map(String str) {
        switch(str) {
            case "RL": return 0; case "FL": return 1; case "RR": return 2; case "FR": return 3;
        }
        return -1;
    }
}

class Feet {
    public int x;
    public int y;

    public Feet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean samePlace(Feet other) {
        return this.x == other.x && this.y == other.y;
    }
}
