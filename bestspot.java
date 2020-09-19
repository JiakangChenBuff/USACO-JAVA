import java.util.*;
public class bestspot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int F = sc.nextInt();
        int C = sc.nextInt();
        int[] best = new int[F];
        for (int i = 0; i < F; i++) {
            best[i] = sc.nextInt();
        }
        int[][] adj = new int[P + 1][P + 1];
        for (int i = 1; i <= P; i++) {
            for (int j = 1; j <= P; j++) {
                adj[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= P; i++) {
            adj[i][i] = 0;
        }
        for (int i = 0; i < C; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int T = sc.nextInt();
            adj[a][b] = T;
            adj[b][a] = T;
        }

        for (int k = 1; k <= P; k++) {
            for (int i = 1; i <= P; i++) {
                if (adj[i][k] < Integer.MAX_VALUE) {
                    for (int j = 1; j <= P; j++) {
                        if (adj[k][j] < Integer.MAX_VALUE) {
                            adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                        }
                    }
                }
            }
        }

        double average = Double.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i <= P; i++) {
            double sum = 0;
            for (int j = 0; j < F; j++) {
                sum += adj[i][best[j]];
            }
            sum /= F;
            if (sum < average) {
                ans = i;
                average = sum;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
