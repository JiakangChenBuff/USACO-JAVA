import java.util.*;
public class contest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][] adj1 = new boolean[N + 1][N + 1];
        boolean[][] adj2 = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj1[B][A] = true;
            adj2[A][B] = true;
        }

        int[] counts = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            counts[i] = bfs(i, adj1) + bfs(i, adj2);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (counts[i] == N - 1) {
                ans++;
            }
        }
        System.out.println(ans);
        sc.close();
    }

    public static int bfs(int s, boolean[][] adj) {
        boolean[] vis = new boolean[adj.length];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        vis[s] = true;
        int count = 0;
        while (!Q.isEmpty()) {
            int curr = Q.poll();
            for (int i = 1; i < adj.length; i++) {
                if (adj[curr][i] && !vis[i]) {
                    vis[i] = true;
                    Q.add(i);
                    count++;
                }
            }
        }
        return count;
    }
}
