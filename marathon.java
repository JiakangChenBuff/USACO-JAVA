import java.util.*;
public class marathon {
    public static int pts[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        pts = new int[N][2];
        for (int i = 0; i < N; i++) {
            pts[i][0] = sc.nextInt();
            pts[i][1] = sc.nextInt();
        }
        int[][] dp = new int[N][K + 1];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = dis(i - 1, i) + dp[i - 1][j];
                for (int skips = 1; skips < i && skips <= j; skips++) {
                    dp[i][j] = Math.min(dp[i][j], dis(i - skips - 1, i) + dp[i - skips - 1][j - skips]);
                }
            }
        }
        System.out.println(dp[N - 1][K]);
        sc.close();
    }

    public static int dis(int a, int b) {
        return Math.abs(pts[a][0] - pts[b][0]) + Math.abs(pts[a][1] - pts[b][1]);
    }
}
