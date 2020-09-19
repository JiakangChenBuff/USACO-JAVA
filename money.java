import java.util.*;
public class money {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = sc.nextInt();
        }
        long[][] dp = new long[V + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j <= N; j++) {
                if (j - arr[i] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[V][N]);
        sc.close();
    }
}
