import java.util.*;
public class pageant2 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[][] hide = new int[N][M];
        for (int r = 0; r < N; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < M; c++) {
                if (line.substring(c, c + 1).equals(".")) {
                    hide[r][c] = Integer.MAX_VALUE;
                } else {
                    hide[r][c] = 0;
                }
            }
        }
        int count = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (hide[r][c] == 0) {
                    count++;
                    hide[r][c] = count;
                    Queue<int[]> Q = new LinkedList<int[]>();
                    Q.add(new int[] {r - 1, c});
                    Q.add(new int[] {r + 1, c});
                    Q.add(new int[] {r, c - 1});
                    Q.add(new int[] {r, c + 1});
                    while (!Q.isEmpty()) {
                        int[] x = Q.poll();
                        if (x[0] >= 0 && x[0] < N && x[1] >= 0 && x[1] < M && hide[x[0]][x[1]] != Integer.MAX_VALUE && hide[x[0]][x[1]] != count) {
                            hide[x[0]][x[1]] = count;
                            Q.add(new int[] {x[0] - 1, x[1]});
                            Q.add(new int[] {x[0] + 1, x[1]});
                            Q.add(new int[] {x[0], x[1] - 1});
                            Q.add(new int[] {x[0], x[1] + 1});
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (hide[r][c] == 1) {
                    int[][] dis = new int[N][M];
                    boolean[][] vis = new boolean[N][M];
                    vis[r][c] = true;
                    Queue<int[]> Q = new LinkedList<int[]>();
                    Q.add(new int[] {r, c});
                    while (!Q.isEmpty()) {
                        int[] x = Q.poll();
                        if (x[0] - 1 >= 0 && x[0] - 1< N && x[1] >= 0 && x[1] < M && !vis[x[0] - 1][x[1]]) {
                            vis[x[0] - 1][x[1]] = true;
                            dis[x[0] - 1][x[1]] = dis[x[0]][x[1]] + 1;
                            Q.add(new int[] {x[0] - 1, x[1]});
                        }
                        if (x[0] >= 0 && x[0] < N && x[1] - 1 >= 0 && x[1] - 1 < M && !vis[x[0]][x[1] - 1]) {
                            vis[x[0]][x[1] - 1] = true;
                            dis[x[0]][x[1] - 1] = dis[x[0]][x[1]] + 1;
                            Q.add(new int[] {x[0], x[1] - 1});
                        }
                        if (x[0] + 1 >= 0 && x[0] + 1 < N && x[1] >= 0 && x[1] < M && !vis[x[0] + 1][x[1]]) {
                            vis[x[0] + 1][x[1]] = true;
                            dis[x[0] + 1][x[1]] = dis[x[0]][x[1]] + 1;
                            Q.add(new int[] {x[0] + 1, x[1]});
                        }
                        if (x[0] >= 0 && x[0] < N && x[1] + 1 >= 0 && x[1] + 1 < M && !vis[x[0]][x[1] + 1]) {
                            vis[x[0]][x[1] + 1] = true;
                            dis[x[0]][x[1] + 1] = dis[x[0]][x[1]] + 1;
                            Q.add(new int[] {x[0], x[1] + 1});
                        }
                    }
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (hide[i][j] == 2) {
                                min = Math.min(min, dis[i][j]);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min - 1);
        sc.close();
    }
}
