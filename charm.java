import java.util.*;
public class charm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] charm = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            charm[i][0] = sc.nextInt();
            charm[i][1] = sc.nextInt();
        }
        int[] prev = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            int[] curr = new int[M + 1];
            for (int j = 1; j <= M; j++) {
                if (j - charm[i][0] >= 0) {
                    curr[j] = Math.max(prev[j], charm[i][1] + prev[j - charm[i][0]]);
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        System.out.println(prev[M]);
        sc.close();
    }
}
