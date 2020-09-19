import java.util.*;
@SuppressWarnings("unchecked")
public class packdel {
    public static int N;
    public static ArrayList<int[]>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            adj[A].add(new int[] {B, C});
            adj[B].add(new int[] {A, C});
        }
        System.out.println(dijkstra());
        sc.close();
    }

    public static int dijkstra() {
        int[] weight = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        boolean[] vis = new boolean[N + 1];
        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Q.add(new int[] {1, 0});
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (vis[curr[0]]) {
                continue;
            }
            vis[curr[0]] = true;
            for (int i = 0; i < adj[curr[0]].size(); i++) {
                int v = adj[curr[0]].get(i)[0];
                int w = adj[curr[0]].get(i)[1];
                if (!vis[v] && weight[v] > weight[curr[0]] + w) {
                    weight[v] = weight[curr[0]] + w;
                    Q.add(new int[] {v, weight[v]});
                }
            }
        }
        return weight[N];
    }
}
