import java.util.*;
public class hopscotch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextInt();
        int[][] mat = new int[R][C];
        long[][] ans = new long[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                mat[r][c] = sc.nextInt();
            }
        }
        ans[R - 1][C - 1] = 1;
        for (int r = R - 2; r >= 0; r--) {
            for (int c = C - 2; c >= 0; c--) {
                for (int i = r + 1; i < R; i++) {
                    for (int j = c + 1; j < C; j++) {
                        if (mat[r][c] != mat[i][j]) {
                            ans[r][c] += ans[i][j];
                            ans[r][c] %= 1000000007;
                        }
                    }
                }
            }
        }
        System.out.println(ans[0][0]);
        sc.close();
    }
}
