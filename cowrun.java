import java.util.*;
public class cowrun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] ps = new int[N + 2];
        for (int i = 2; i <= N + 1; i++) {
            ps[i] = ps[i - 1] + sc.nextInt();
        }
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1];
            for (int j = 1; j <= M && i - 2 * j >= 0; j++) {
                dp[i] = Math.max(dp[i], ps[i - j + 1] - ps[i - 2 * j + 1] + dp[i - 2 * j]);
            }
        }
        System.out.println(dp[N]);
        sc.close();
    }
}
