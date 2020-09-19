import java.util.*;
public class knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[][] candies = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            candies[i][0] = sc.nextInt();
            candies[i][1] = sc.nextInt();
        }
        long[] prev = new long[C + 1];
        for (int i = 1; i <= N; i++) {
            long[] curr = new long[C + 1];
            for (int j = 1; j <= C; j++) {
                if (j - candies[i][0] >= 0) {
                    curr[j] = Math.max(prev[j], candies[i][1] + prev[j - candies[i][0]]);
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        System.out.println(prev[C]);
        sc.close();
    }
}
