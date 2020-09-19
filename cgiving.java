import java.util.*;
@SuppressWarnings("unchecked")
public class cgiving {
    public static int N;
    public static ArrayList<int[]>[] adj;
    public static int[] dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int B = sc.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int R = sc.nextInt();
            int S = sc.nextInt();
            int L = sc.nextInt();
            adj[R].add(new int[] {S, L});
            adj[S].add(new int[] {R, L});
        }

        dijkstra(1);
        for (int i = 0; i < B; i++) {
            int P = sc.nextInt();
            int Q = sc.nextInt();
            System.out.println(dis[P] + dis[Q]);
        }
        sc.close();
    }

    public static void dijkstra(int s) {
        dis = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[s] = 0;
        boolean[] vis = new boolean[N + 1];
        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Q.add(new int[] {s, 0});
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (vis[curr[0]]) {
                continue;
            }
            vis[curr[0]] = true;
            for (int i = 0; i < adj[curr[0]].size(); i++) {
                int v = adj[curr[0]].get(i)[0];
                int w = adj[curr[0]].get(i)[1];
                if (!vis[v] && dis[v] > dis[curr[0]] + w) {
                    dis[v] = dis[curr[0]] + w;
                    Q.add(new int[] {v, dis[v]});
                }
            }
        }
    }
}
