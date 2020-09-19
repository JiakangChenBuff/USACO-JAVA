import java.util.*;
public class danger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] path = new int[M - 1][2];
        int prev = sc.nextInt();
        for (int i = 0; i < M - 1; i++) {
            int curr = sc.nextInt();
            path[i][0] = prev;
            path[i][1] = curr;
            prev = curr;
        }

        int[][] adj = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++){
                adj[r][c] = sc.nextInt();
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < M - 1; i++) {
            ans += adj[path[i][0]][path[i][1]];
        }
        System.out.println(ans);
        sc.close();
    }
}
