import java.util.*;
public class stamps2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int W = K * arr[N];
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= W; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j - arr[i] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - arr[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= W; i++) {
            if (dp[N][i] <= K) {
                ans++;
            } else {
                break;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
