import java.util.*;
public class gates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int E = 0;
        int V = 1;
        boolean[][][] vis = new boolean[2 * N][2 * N][5];
        int r = N;
        int c = N;
        vis[r][c][4] = true;
        int[][] moves = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < N; i++) {
            int curr = map(str.charAt(i));
            int newR = r + moves[curr][0];
            int newC = c + moves[curr][1];
            if (!vis[newR][newC][4]) {
                V++;
                vis[newR][newC][4] = true;
            }
            if (!vis[r][c][curr]) {
                vis[r][c][curr] = true;
                vis[newR][newC][(curr + 2) % 4] = true;
                E++;
            }
            r = newR;
            c = newC;
        }
        System.out.println(E + 2 - V - 1);
        sc.close();
    }

    public static int map(char c) {
        switch (c) {
            case 'N': return 0; case 'E': return 1; case 'S': return 2; case 'W': return 3; default: return -1;
        }
    }
}
