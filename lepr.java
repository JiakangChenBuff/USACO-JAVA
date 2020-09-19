import java.util.*;
public class lepr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                matrix[r][c] = sc.nextInt();
            }
        }
        int[][] rows = new int[4 * N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                rows[r][c] = matrix[r][c];
            }
        }
        for (int r = N; r < 2 * N; r++) {
            for (int c = 0; c < N; c++) {
                rows[r][c] = matrix[c][r - N];
            }
        }
        for (int r = 2 * N; r < 3 * N; r++) {
            int[] result = new int[N];
            int tR = r - 2 * N;
            int tC = 0;
            for (int i = 0; i < N; i++) {
                result[i] = matrix[tR][tC];
                if (tR != 0) {
                    tR--;
                } else {
                    tR = N - 1;
                }
                tC++;
            }
            rows[r] = result;
        }
        for (int r = 3 * N; r < 4 * N; r++) {
            int[] result = new int[N];
            int tR = r - 3 * N;
            int tC = 0;
            for (int i = 0; i < N; i++) {
                result[i] = matrix[tR][tC];
                if (tR != N - 1) {
                    tR++;
                } else {
                    tR = 0;
                }
                tC++;
            }
            rows[r] = result;
        }
        int maxSum = Integer.MIN_VALUE;
        for (int r = 0; r < 4 * N; r++) {
            for (int c = 0; c < N; c++) {
                int sum = maxContSum(rows[r], c);
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
        sc.close();
    }

    public static int maxContSum(int[] row, int start) {
        int[] ps = new int[row.length + 1];
        ps[0] = 0;
        int count = 0;
        int index = start;
        while (count < row.length) {
            ps[count + 1] = ps[count] + row[index];
            count++;
            index++;
            index %= row.length;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < ps.length; i++) {
            max = Math.max(max, ps[i]);
        }
        return max;
    }
}
