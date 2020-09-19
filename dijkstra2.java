import java.util.*;
@SuppressWarnings("unchecked")
public class dijkstra2 {
    public static int V;
    public static ArrayList<int[]>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();
        int S = sc.nextInt();
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            adj[A].add(new int[] {B, C});
            adj[B].add(new int[] {A, C});
        }

        int[] dis = dijkstra(S);
        for (int i = 1; i <= V; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dis[i]);
            }
        }
        sc.close();
    }

    public static int[] dijkstra(int S) {
        int[] weights = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            weights[i] = Integer.MAX_VALUE;
        }
        weights[S] = 0;
        boolean[] vis = new boolean[V + 1];
        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        Q.add(new int[] {S, 0});
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (vis[curr[0]]) {
                continue;
            }
            vis[curr[0]] = true;
            for (int i = 0; i < adj[curr[0]].size(); i++) {
                int v = adj[curr[0]].get(i)[0];
                int w = adj[curr[0]].get(i)[1];
                if (!vis[v] && weights[v] > weights[curr[0]] + w) {
                    weights[v] = weights[curr[0]] + w;
                    Q.add(new int[] {v, weights[v]});
                }
            }
        }
        return weights;
    }
}
