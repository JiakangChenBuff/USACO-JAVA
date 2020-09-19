import java.util.*;
public class hurdles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int[][] adj = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                adj[r][c] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= N; i++) {
            adj[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int H = sc.nextInt();
            adj[A][B] = H;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (adj[i][k] < Integer.MAX_VALUE) {
                    for (int j = 1; j <= N; j++) {
                        if (adj[k][j] < Integer.MAX_VALUE) {
                            adj[i][j] = Math.min(adj[i][j], Math.max(adj[i][k], adj[k][j]));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (adj[A][B] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(adj[A][B]);
            }
        }
        sc.close();
    }
}
