import java.util.*;
public class delivery {
    public static int N;
    public static boolean[][] adj;
    public static int[] xSort;
    public static int[] ySort;
    public static int[] dr = new int[] {0, -1, 0, 1};
    public static int[] dc = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        Set<Integer> xVal = new TreeSet<>();
        Set<Integer> yVal = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            xVal.add(x[i]);
            xVal.add(x[i] - 1);
            xVal.add(x[i] + 1);
            yVal.add(y[i]);
            yVal.add(y[i] - 1);
            yVal.add(y[i] + 1);
        }
        xSort = new int[xVal.size()];
        ySort = new int[yVal.size()];
        int index = 0;
        for (Integer i : xVal) {
            xSort[index] = i;
            index++;
        }
        index = 0;
        for (Integer i : yVal) {
            ySort[index] = i;
            index++;
        }
        adj = new boolean[ySort.length][xSort.length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < ySort.length; j++) {
                if (y[i] == ySort[j]) {
                    y[i] = j;
                    break;
                }
            }
            for (int j = 0; j < xSort.length; j++) {
                if (x[i] == xSort[j]) {
                    x[i] = j;
                    break;
                }
            }
            adj[y[i]][x[i]] = true;
        }

        int[] next = new int[N];
        for (int i = 0; i < N - 1; i++) {
            next[i] = i + 1;
        }
        next[N - 1] = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            adj[y[i]][x[i]] = false;
            adj[y[next[i]]][x[next[i]]] = false;
            int dis = floodfill(y[i], x[i], y[next[i]], x[next[i]]);
            if (dis == Integer.MAX_VALUE) {
                sum = -1;
                break;
            } else {
                sum += dis;
            }
            adj[y[i]][x[i]] = true;
            adj[y[next[i]]][x[next[i]]] = true;
        }
        System.out.println(sum);
        sc.close();
    }

    public static int floodfill(int sr, int sc, int er, int ec) {
        int[][] dis = new int[adj.length][adj[0].length];
        for (int r = 0; r < dis.length; r++) {
            for (int c = 0; c < dis[0].length; c++) {
                dis[r][c] = Integer.MAX_VALUE;
            }
        }
        boolean[][] vis = new boolean[adj.length][adj[0].length];
        dis[sr][sc] = 0;
        PriorityQueue<int[]> Q = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        Q.add(new int[] {sr, sc, 0});
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            if (vis[curr[0]][curr[1]]) {
                continue;
            }
            vis[curr[0]][curr[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if (isValid(nr, nc) && !vis[nr][nc] && !adj[nr][nc] && dis[nr][nc] > dis[curr[0]][curr[1]] + Math.abs(ySort[nr] - ySort[curr[0]]) + Math.abs(xSort[nc] - xSort[curr[1]])) {
                    dis[nr][nc] = dis[curr[0]][curr[1]] + Math.abs(ySort[nr] - ySort[curr[0]]) + Math.abs(xSort[nc] - xSort[curr[1]]);
                    Q.add(new int[] {nr, nc, dis[nr][nc]});
                }
            }
        }
        return dis[er][ec];
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < adj.length && c >= 0 && c < adj[0].length;
    }
}
