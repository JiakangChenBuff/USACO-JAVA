import java.util.*;
public class roads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] pts = new int[N][2];
        for (int i = 0; i < N; i++) {
            pts[i][0] = sc.nextInt();
            pts[i][1] = sc.nextInt();
        }
        double[][] adj = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                adj[i][j] = dis(pts[i][0], pts[i][1], pts[j][0], pts[j][1]);
                adj[j][i] = adj[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            adj[i][i] = Double.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            adj[a][b] = 0;
            adj[b][a] = 0;
        }

        double[] weights = new double[N];
        for (int i = 1; i < N; i++) {
            weights[i] = Double.MAX_VALUE;
        }
        int[] from = new int[N];
        boolean[] vis = new boolean[N];
        vis[0] = true;
        PriorityQueue<double[]> Q = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[2], b[2]);
            }
        });
        for (int i = 1; i < N; i++) {
            Q.add(new double[] {0, i, adj[0][i]});
            weights[i] = adj[0][i];
            from[i] = 0;
        }
        double sum = 0;
        while (!Q.isEmpty()) {
            double[] curr = Q.poll();
            if (from[(int) curr[1]] == (int) curr[0]) {
                vis[(int) curr[1]] = true;
                sum += curr[2];
                for (int i = 0; i < N; i++) {
                    if (i != (int) curr[1] && !vis[i] && weights[i] > adj[(int) curr[1]][i]) {
                        weights[i] = adj[(int) curr[1]][i];
                        from[i] = (int) curr[1];
                        Q.add(new double[] {curr[1], i, weights[i]});
                    }
                }
            }
        }
        System.out.printf("%.2f %n", sum);
        sc.close();
    }

    public static double dis(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
