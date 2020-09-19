import java.util.*;
public class plumb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] depths = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                depths[r][c] = sc.nextInt();
            }
        }
        int max = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int d = depths[r][c];
                if (r != 0 && c != 0) {
                    if (depths[r - 1][c - 1] == d) {
                        max = Math.max(max, d);
                    }
                }
                if (r != 0) {
                    if (depths[r - 1][c] == d) {
                        max = Math.max(max, d);
                    }
                }
                if (r != 0 && c != C - 1) {
                    if (depths[r - 1][c + 1] == d) {
                        max = Math.max(max, d);
                    }
                }
                if (c != 0) {
                    if (depths[r][c - 1] == d) {
                        max = Math.max(max, d);
                    }
                }
                if (c != C - 1) {
                    if (depths[r][c + 1] == d) {
                        max = Math.max(max, d);
                    }
                }
                if (r != R - 1 && c != 0) {
                    if (depths[r + 1][c - 1] == d) {
                        max = Math.max(max, d);
                    }
                }
                if (r != R - 1) {
                    if (depths[r + 1][c] == d) {
                        max = Math.max(max, d);
                    }
                }
                if (r != R - 1 && c != C - 1) {
                    if (depths[r + 1][c + 1] == d) {
                        max = Math.max(max, d);
                    }
                }
            }
        }
        System.out.println(max);
        sc.close();
    }
}
