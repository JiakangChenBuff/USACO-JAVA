import java.util.*;
public class irrigation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        int[][] pts = new int[N][2];
        for (int i = 0; i < N; i++) {
            pts[i][0] = sc.nextInt();
            pts[i][1] = sc.nextInt();
        }

        int[][] adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int cost = (int) Math.pow(pts[i][0] - pts[j][0], 2) + (int) Math.pow(pts[i][1] - pts[j][1], 2);
                if (cost >= C) {
                    adj[i][j] = cost;
                    adj[j][i] = cost;
                }
            }
        }

        boolean[] vis = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < N; i++) {
                if (adj[curr][i] > 0 && !vis[i]) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        boolean connected = true;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                connected = false;
                break;
            }
        }
        if (connected) {
            int[] weights = new int[N];
            for (int i = 1; i < N; i++) {
                weights[i] = Integer.MAX_VALUE;
            }
            int[] from = new int[N];
            vis = new boolean[N];
            vis[0] = true;
            PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[2] - b[2];
                }
            });
            for (int i = 1; i < N; i++) {
                if (adj[0][i] > 0) {
                    Q.add(new int[] {0, i, adj[0][i]});
                    weights[i] = adj[0][i];
                    from[i] = 0;
                }
            }
            long sum = 0;
            while (!Q.isEmpty()) {
                int[] curr = Q.poll();
                if (from[curr[1]] == curr[0]) {
                    vis[curr[1]] = true;
                    sum += curr[2];
                    for (int i = 0; i < N; i++) {
                        if (adj[curr[1]][i] > 0 && !vis[i] && weights[i] > adj[curr[1]][i]) {
                            Q.add(new int[] {curr[1], i, adj[curr[1]][i]});
                            from[i] = curr[1];
                            weights[i] = adj[curr[1]][i];
                        }
                    }
                }
            }
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }
}
