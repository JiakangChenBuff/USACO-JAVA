import java.util.*;
public class nocross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr_i = new int[N];
        int[] arr_j = new int[N];
        int[] ind_x = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr_i[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arr_j[i] = sc.nextInt();
            ind_x[arr_j[i]] = i;
        }

        int[][] dp = new int[N + 1][N + 1];
        for (int r = N - 1; r >= 0; r--) {
            for (int c = N - 1; c >= 0; c--) {
                int max = 0;
                for (int friend = arr_i[r] - 4; friend <= arr_i[r] + 4; friend++) {
                    if (friend >= 1 && friend <= N && ind_x[friend] >= c) {
                        max = Math.max(max, 1 + dp[r + 1][ind_x[friend] + 1]);
                    }
                }
                dp[r][c] = Math.max(max, dp[r + 1][c]);
            }
        }
        System.out.println(dp[0][0]);
        sc.close();
    }
}
