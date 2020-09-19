import java.util.*;
public class lis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            s[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        int max = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (s[j] < s[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        sc.close();
    }
}
