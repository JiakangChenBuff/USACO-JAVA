import java.util.*;
public class dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int S = sc.nextInt();

        int[][] adj = new int[V + 1][V + 1];
        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj[A][B] = sc.nextInt();
            adj[B][A] = adj[A][B];
        }

        int[] weights = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            weights[i] = Integer.MAX_VALUE;
        }
        weights[S]=  0;

        boolean[] vis = new boolean[V + 1];
        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        Q.add(new int[] {S, 0});
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (!vis[curr[0]]) {
                vis[curr[0]] = true;
                for (int i = 1; i <= V; i++) {
                    if (adj[curr[0]][i] > 0 && !vis[i] && weights[i] > weights[curr[0]] + adj[curr[0]][i]) {
                        weights[i] = weights[curr[0]] + adj[curr[0]][i];
                        Q.add(new int[] {i, weights[i]});
                    }
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (weights[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(weights[i]);
            }
        }
        sc.close();
    }
}
