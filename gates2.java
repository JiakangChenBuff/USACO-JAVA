import java.util.*;
public class gates2 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[4 * N][4 * N];
        for (int r = 0; r < 4 * N; r += 2) {
            for (int c = 0; c < 4 * N; c++) {
                grid[r][c] = -1;
            }
        }
        for (int r = 0; r < 4 * N; r++) {
            for (int c = 0; c < 4 * N; c += 2) {
                grid[r][c] = -1;
            }
        }
        String line = sc.next();
        int sR = 2 * N;
        int sC = 2 * N;
        grid[sR][sC] = -2;
        for (int i = 0; i < N; i++) {
            if (line.substring(i, i + 1).equals("N")) {
                sR -= 2;
                grid[sR + 1][sC] = -2;
            } else if (line.substring(i, i + 1).equals("S")) {
                sR += 2;
                grid[sR - 1][sC] = -2;
            } else if (line.substring(i, i + 1).equals("E")) {
                sC += 2;
                grid[sR][sC - 1] = -2;
            } else {
                sC -= 2;
                grid[sR][sC + 1] = -2;
            }
            grid[sR][sC] = -2;
        }
        int count = 0;
        for (int r = 0; r < 4 * N; r++) {
            for (int c = 0; c < 4 * N; c++) {
                if (grid[r][c] == 0) {
                    count++;
                    Queue<int[]> Q = new LinkedList<int[]>();
                    grid[r][c] = count;
                    Q.add(new int[] {r, c});
                    while (!Q.isEmpty()) {
                        int[] x = Q.poll();
                        if (x[0] + 2 < 4 * N && grid[x[0] + 1][x[1]] == -1 && grid[x[0] + 2][x[1]] == 0) {
                            grid[x[0] + 2][x[1]] = count;
                            Q.add(new int[] {x[0] + 2, x[1]});
                        }
                        if (x[0] - 2 >= 0 && grid[x[0] - 1][x[1]] == -1 && grid[x[0] - 2][x[1]] == 0) {
                            grid[x[0] - 2][x[1]] = count;
                            Q.add(new int[] {x[0] - 2, x[1]});
                        }
                        if (x[1] - 2 >= 0 && grid[x[0]][x[1] - 1] == -1 && grid[x[0]][x[1] - 2] == 0) {
                            grid[x[0]][x[1] - 2] = count;
                            Q.add(new int[] {x[0], x[1] - 2});
                        }
                        if (x[1] + 2 < 4 * N && grid[x[0]][x[1] + 1] == -1 && grid[x[0]][x[1] + 2] == 0) {
                            grid[x[0]][x[1] + 2] = count;
                            Q.add(new int[] {x[0], x[1] + 2});
                        }
                    }
                }
            }
        }
        System.out.println(count - 1);
        sc.close();
    }
}
