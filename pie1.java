import java.util.*;
public class pie1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] mat = new int[R + 2][C];
        for (int r = 1; r <= R; r++) {
            for (int c = 0; c < C; c++) {
                mat[r][c] = sc.nextInt();
            }
        }
        int[][] val = new int[R + 2][C];
        val[1][0] = mat[1][0];
        for (int c = 0; c < C - 1; c++) {
            for (int r = 1; r <= c + 1 && r <= R; r++) {
                val[r - 1][c + 1] = Math.max(val[r - 1][c + 1], val[r][c] + mat[r - 1][c + 1]);
                val[r][c + 1] = Math.max(val[r][c + 1], val[r][c] + mat[r][c + 1]);
                val[r + 1][c + 1] = Math.max(val[r + 1][c + 1], val[r][c] + mat[r + 1][c + 1]);
            }
        }
        System.out.println(val[R][C - 1]);
        sc.close();
    }
}
