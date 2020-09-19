import java.util.*;
@SuppressWarnings({"unchecked", "rawtypes"})
public class pwalk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        ArrayList[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList();
        }
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();
            adj[a].add(new int[] {b, l});
            adj[b].add(new int[] {a ,l});
        }

        for (int i = 0; i < Q; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            System.out.println(dfs(p1, p2, adj));
        }
        sc.close();
    }

    public static int dfs(int s, int e, ArrayList[] adj) {
        int[] dis = new int[adj.length];
        boolean[] vis = new boolean[adj.length];
        vis[s] = true;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        while (!Q.isEmpty()) {
            int curr = Q.poll();
            for (Object o : adj[curr]) {
                int[] neighbor = (int[]) o;
                if (!vis[neighbor[0]]) {
                    vis[neighbor[0]] = true;
                    dis[neighbor[0]] = dis[curr] + neighbor[1];
                    Q.add(neighbor[0]);
                }
            }
        }
        return dis[e];
    }
}
