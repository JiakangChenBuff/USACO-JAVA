import java.util.*;
public class egroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[N][4];
        dp[0][1] = (arr[0] == 1) ? 0 : 1;
        dp[0][2] = (arr[0] == 2) ? 0 : 1;
        dp[0][3] = (arr[0] == 3) ? 0 : 1;
        for (int i = 1; i < N; i++) {
            int[] add = new int[] {0, arr[i] == 1 ? 0 : 1, arr[i] == 2 ? 0 : 1, arr[i] == 3 ? 0 : 1};
            dp[i][1] = add[1] + dp[i - 1][1];
            dp[i][2] = Math.min(add[2] + dp[i - 1][2], add[2] + dp[i - 1][1]);
            dp[i][3] = Math.min(Math.min(add[3] + dp[i - 1][3], add[3] + dp[i - 1][2]), add[3] + dp[i - 1][1]);
        }
        int min1 = Math.min(Math.min(dp[N - 1][1], dp[N - 1][2]), dp[N - 1][3]);
        dp = new int[N][4];
        dp[0][1] = (arr[0] == 1) ? 0 : 1;
        dp[0][2] = (arr[0] == 2) ? 0 : 1;
        dp[0][3] = (arr[0] == 3) ? 0 : 1;
        for (int i = 1; i < N; i++) {
            int[] add = new int[] {0, arr[i] == 1 ? 0 : 1, arr[i] == 2 ? 0 : 1, arr[i] == 3 ? 0 : 1};
            dp[i][1] = Math.min(Math.min(add[1] + dp[i - 1][1], add[1] + dp[i - 1][2]), add[1] + dp[i - 1][3]);
            dp[i][2] = Math.min(add[2] + dp[i - 1][3], add[2] + dp[i - 1][2]);
            dp[i][3] = add[3] + dp[i - 1][3];
        }
        int min2 = Math.min(Math.min(dp[N - 1][1], dp[N - 1][2]), dp[N - 1][3]);
        System.out.println(Math.min(min1, min2));
        sc.close();
    }
}
