import java.util.*;
public class space2 {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[][] field = new int[N][N];
        for (int r = 0; r < N; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < N; c++) {
                if (line.substring(c, c + 1).equals(".")) {
                    field[r][c] = Integer.MAX_VALUE;
                } else {
                    field[r][c] = 0;
                }
            }
        }
        int count = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (field[r][c] == 0) {
                    count++;
                    Queue<int[]> Q = new LinkedList<int[]>();
                    Q.add(new int[] {r - 1, c});
                    Q.add(new int[] {r + 1, c});
                    Q.add(new int[] {r, c - 1});
                    Q.add(new int[] {r, c + 1});
                    while (!Q.isEmpty()) {
                        int[] x = Q.poll();
                        if (x[0] >= 0 && x[0] < N && x[1] >= 0 && x[1] < N && field[x[0]][x[1]] != Integer.MAX_VALUE && field[x[0]][x[1]] != count) {
                            field[x[0]][x[1]] = count;
                            Q.add(new int[] {x[0] - 1, x[1]});
                            Q.add(new int[] {x[0] + 1, x[1]});
                            Q.add(new int[] {x[0], x[1] - 1});
                            Q.add(new int[] {x[0], x[1] + 1});
                        }
                    }
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
