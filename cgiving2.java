import java.util.*;
public class cgiving2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int B = sc.nextInt();

        int[][] adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                adj[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < M; i++) {
            int R = sc.nextInt();
            int S = sc.nextInt();
            adj[R][S] = Math.min(adj[R][S], sc.nextInt());
            adj[S][R] = adj[R][S];
        }

        int[] weights = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            weights[i] = Integer.MAX_VALUE;
        }

        boolean[] vis = new boolean[N + 1];

        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[1] - b[1];
           }
        });
        Q.add(new int[] {1, 0});
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (!vis[curr[0]]) {
                vis[curr[0]] = true;
                for (int i = 1; i <= N; i++) {
                    if (adj[curr[0]][i] < Integer.MAX_VALUE && !vis[i] && weights[i] > weights[curr[0]] + adj[curr[0]][i]) {
                        weights[i] = weights[curr[0]] + adj[curr[0]][i];
                        Q.add(new int[] {i, weights[i]});
                    }
                }
            }
        }

        for (int i = 0; i < B; i++) {
            int P = sc.nextInt();
            int q = sc.nextInt();
            System.out.println(weights[P] + weights[q]);
        }
        sc.close();
    }
}
