import java.util.*;
public class baleshare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean[][][] dp = new boolean[N + 1][801][801];
        dp[0][0][0] = true;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int curr = sc.nextInt();
            sum += curr;
            for (int j = 0; j < 701; j++) {
                for (int k = 0; k < 701; k++) {
                    if (dp[i - 1][j][k]) {
                        dp[i][j + curr][k] = true;
                        dp[i][j][k + curr] = true;
                        dp[i][j][k] = true;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 701; j++) {
            for (int k = 0; k < 701; k++) {
                if (dp[N][j][k]) {
                    min = Math.min(min, Math.max(j, Math.max(k, sum - j - k)));
                }
            }
        }
        System.out.println(min);
        sc.close();
    }
}
