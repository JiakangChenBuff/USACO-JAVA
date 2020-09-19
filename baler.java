import java.util.*;
public class baler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X_t = sc.nextInt();
        int Y_t = sc.nextInt();
        int[][] balers=  new int[N][3]; // (x_value, y_value, radius)
        int s = 0;
        int e = 0;
        for (int i = 0; i < N; i++) {
            balers[i][0] = sc.nextInt();
            balers[i][1] = sc.nextInt();
            balers[i][2] = sc.nextInt();
            if (balers[i][0] == 0 && balers[i][1] == 0) {
                s = i;
            } else if (balers[i][0] == X_t && balers[i][1] == Y_t) {
                e = i;
            }
        }

        boolean[][] adj = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (connected(balers[i], balers[j])) {
                    adj[i][j] = true;
                    adj[j][i] = true;
                }
            }
        }

        int[] parent = new int[N];
        parent[s] = -1;
        boolean[] vis = new boolean[N];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        vis[s] = true;
        while (!Q.isEmpty()) {
            int curr = Q.poll();
            for (int i = 0; i < N; i++) {
                if (adj[curr][i] && !vis[i]) {
                    vis[i] = true;
                    parent[i] = curr;
                    Q.add(i);
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        path.add(e);
        int curr = e;
        while (parent[curr] != -1) {
            curr = parent[curr];
            path.add(curr);
        }
        double ans = 10000;
        double prevS = 10000;
        for (int i = path.size() - 2; i >= 0; i--) {
            double currS = prevS * balers[path.get(i + 1)][2] / balers[path.get(i)][2];
            ans = ans + currS;
            prevS = currS;
        }
        System.out.println((int) ans);
        sc.close();
    }

    public static boolean connected(int[] a, int[] b) {
        return ((int) Math.pow(a[0] - b[0], 2) + (int) Math.pow(a[1] - b[1], 2)) == ((int) Math.pow(a[2] + b[2], 2));
    }
}
