import java.util.*;
@SuppressWarnings("unchecked")
public class mst2 {
    public static int V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<int[]>[] adj = new ArrayList[V + 1];
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

        System.out.println(mst(adj));
        sc.close();
    }

    public static int mst(ArrayList<int[]>[] adj) {
        int sum = 0;
        int[] weight = new int[V + 1];
        for (int i = 2; i <= V; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        boolean[] vis = new boolean[V + 1];
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
            sum += curr[1];
            for (int i = 0; i < adj[curr[0]].size(); i++) {
                int v = adj[curr[0]].get(i)[0];
                int w = adj[curr[0]].get(i)[1];
                if (!vis[v] && weight[v] > w) {
                    weight[v] = w;
                    Q.add(new int[] {v, w});
                }
            }
        }
        return sum;
    }
}
