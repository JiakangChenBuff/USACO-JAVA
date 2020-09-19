import java.util.*;
public class agrinet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] adj = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                adj[r][c] = sc.nextInt();
            }
        }

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.MAX_VALUE;
        }
        int[] from = new int[N];

        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        boolean[] vis = new boolean[N];
        vis[0] = true;
        for (int i = 1; i < N; i++) {
            Q.add(new int[] {0, i, adj[0][i]});
            weights[i] = adj[0][i];
            from[i] = 0;
        }
        int sum = 0;
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (from[curr[1]] == curr[0]) {
                vis[curr[1]] = true;
                sum += curr[2];
                for (int i = 0; i < N; i++) {
                    if (adj[curr[1]][i] != 0 && !vis[i] && weights[i] > adj[curr[1]][i]) {
                        weights[i] = adj[curr[1]][i];
                        from[i] = curr[1];
                        Q.add(new int[] {curr[1], i, adj[curr[1]][i]});
                    }
                }
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
