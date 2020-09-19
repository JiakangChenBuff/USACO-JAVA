import java.util.*;
public class rblock {
    public static int[][] adj;
    public static int N;
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj[A][B] = sc.nextInt();
            adj[B][A] = adj[A][B];
        }

        int W = dijkstra();
        ArrayList<Integer> path = new ArrayList<>();
        int v = N;
        path.add(N);
        while (parent[v] != 0) {
            v = parent[v];
            path.add(v);
        }
        int ans = 0;
        for (int i = 0; i < path.size() - 1; i++) {
             adj[path.get(i)][path.get(i + 1)] *= 2;
             adj[path.get(i + 1)][path.get(i)] *= 2;
             int w = dijkstra();
             ans = Math.max(ans, w - W);
            adj[path.get(i)][path.get(i + 1)] /= 2;
            adj[path.get(i + 1)][path.get(i)] /= 2;
        }
        System.out.println(ans);
        sc.close();
    }

    public static int dijkstra() {
        int[] weight = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        parent = new int[N + 1];
        boolean[] vis = new boolean[N + 1];
        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Q.add(new int[] {1, 0});
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (!vis[curr[0]]) {
                vis[curr[0]] = true;
                for (int i = 1; i <= N; i++) {
                    if (adj[curr[0]][i] > 0 && !vis[i] && weight[i] > weight[curr[0]] + adj[curr[0]][i]) {
                        weight[i] = weight[curr[0]] + adj[curr[0]][i];
                        parent[i] = curr[0];
                        Q.add(new int[] {i, weight[i]});
                    }
                }
            }
        }
        return weight[N];
    }
}
