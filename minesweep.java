import java.util.*;
public class minesweep {
    public static int N;
    public static int M;
    public static int K;
    public static int[][] mat;
    public static int[][] t;

    public static int[] dr = {-1, -1, -1,  0, 0, 0,  1, 1, 1};
    public static int[] dc = {-1,  0,  1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        mat = new int[N][M];
        t = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                mat[r][c] = sc.nextInt();
            }
        }

        if (!solve(0, 0, K)) {
            System.out.println("NO SOLUTION");
        } else {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (t[r][c] != 0) {
                        System.out.println((r + 1) + " " + (c + 1));
                    }
                }
            }
        }
        sc.close();
    }

    public static boolean solve(int r, int c, int k) {
        if (r > 0 && c > 1 && mat[r - 1][c - 2] > 0) {
            return false;
        }

        if (c >= M) {
            if (r > 0 && mat[r - 1][c - 1] > 0) {
                return false;
            }
            r++;
            c = 0;
        }

        if (r >= N) {
            if (k != 0) {
                return false;
            }

            for (int i = 0; i < M; i++) {
                if (mat[r - 1][i] > 0) {
                    return false;
                }
            }

            return true;
        }

        if (mat[r][c] != 0 && k != 0 && check(r, c)) {
            mine(r, c , -1);
            if (solve(r, c + 1, k - 1)) {
                return true;
            }
            mine(r, c, 1);
        }

        return solve(r, c + 1, k);
    }

    public static boolean check(int r, int c) {
        for (int i = 0; i < 9; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isValid(nr, nc) && mat[nr][nc] == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    public static void mine(int r, int c, int flag) {
        if (flag == -1) {
            t[r][c] = -2;
        } else {
            t[r][c] = 0;
        }

        for (int i = 0; i < 9; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isValid(nr, nc)) {
                mat[nr][nc] += flag;
            }
        }
    }
}
