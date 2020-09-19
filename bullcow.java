import java.util.*;
public class bullcow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] dp = new int[N][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < N; i++) {
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % 5000011;
            if (i - (K + 1) >= 0) {
                dp[i][0] = (dp[i - (K + 1)][0] + dp[i - (K + 1)][1]) % 5000011;
            } else {
                dp[i][0] = 1;
            }
        }
        System.out.println((dp[N - 1][0] + dp[N - 1][1]) % 5000011);
        sc.close();
    }
}
