import java.util.*;
@SuppressWarnings("unchecked")
public class hideseek {
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj[A].add(B);
            adj[B].add(A);
        }

        int[] dis = dfs(adj);
        int index = 0;
        int maxDis = -1;
        for (int i = 1; i <= N; i++) {
            if (dis[i] > maxDis) {
                index = i;
                maxDis = dis[i];
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dis[i] == maxDis) {
                count++;
            }
        }
        System.out.println(index + " " + maxDis + " " + count);
        sc.close();
    }

    public static int[] dfs(ArrayList<Integer>[] adj) {
        int[] dis = new int[N + 1];
        boolean[] vis = new boolean[N + 1];
        vis[1] = true;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        while (!Q.isEmpty()) {
            int curr = Q.poll();
            for (Integer n : adj[curr]) {
                if (!vis[n]) {
                    vis[n] = true;
                    dis[n] = dis[curr] + 1;
                    Q.add(n);
                }
            }
        }
        return dis;
    }
}
