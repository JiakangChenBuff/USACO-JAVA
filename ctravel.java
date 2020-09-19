import java.util.*;
public class ctravel {
    public static int N, M, T, R1, C1, R2, C2, isTree[][], dp[][][];
    public static boolean solved[][][];
    public static int dr[] = {0, -1, 0, 1};
    public static int dc[] = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        sc.nextLine();
        isTree = new int[N][M];
        dp = new int[N][M][T + 1];
        solved = new boolean[N][M][T + 1];
        for (int r = 0; r < N; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < M; c++) {
                isTree[r][c] = (line.charAt(c) == '*') ? 1 : 0;
            }
        }
        R1 = sc.nextInt() - 1;
        C1 = sc.nextInt() - 1;
        R2 = sc.nextInt() - 1;
        C2 = sc.nextInt() - 1;
        dp[R1][C1][0] = 1;
        solved[R1][C1][0] = true;
        System.out.println(sol(R2, C2, T));
        sc.close();
    }

    public static int sol(int i, int j, int k) {
        if (i < 0 || i >= N || j < 0 || j >= M || isTree[i][j] == 1 || (k == 0 && !(i == R1 && j == C1))) {
            return 0;
        }
        if (solved[i][j][k]) {
            return dp[i][j][k];
        }
        for (int x = 0; x < 4; x++) {
            dp[i][j][k] += sol(i + dr[x], j + dc[x], k - 1);
        }
        solved[i][j][k] = true;
        return dp[i][j][k];
    }
}
