import java.util.*;
public class heatwv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int C = sc.nextInt();
        int T_s = sc.nextInt();
        int T_e = sc.nextInt();
        int[][] adj = new int[T + 1][T + 1];
        for (int i = 0; i < C; i++) {
            int R1 = sc.nextInt();
            int R2 = sc.nextInt();
            adj[R1][R2] = sc.nextInt();
            adj[R2][R1] = adj[R1][R2];
        }

        int[] weights = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            weights[i] = Integer.MAX_VALUE;
        }
        weights[T_s] = 0;
        boolean[] vis = new boolean[T + 1];

        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        Q.add(new int[] {T_s, 0});
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (!vis[curr[0]]) {
                vis[curr[0]] = true;
                for (int i = 1; i <= T; i++) {
                    if (adj[curr[0]][i] > 0 && !vis[i] && weights[i] > weights[curr[0]] + adj[curr[0]][i]) {
                        weights[i] = weights[curr[0]] + adj[curr[0]][i];
                        Q.add(new int[] {i, weights[i]});
                    }
                }
            }
        }
        System.out.println(weights[T_e]);
        sc.close();
    }
}
