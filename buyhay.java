import java.util.*;
public class buyhay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int[][] buyer = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            buyer[i][0] = sc.nextInt();
            buyer[i][1] = sc.nextInt();
        }
        int[][] dp = new int[N + 1][H + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= H; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= H; j++) {
                if (j - buyer[i][0] < 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], buyer[i][1]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], buyer[i][1] + dp[i][j - buyer[i][0]]);
                }
            }
        }
        System.out.println(dp[N][H]);
        sc.close();
    }
}
