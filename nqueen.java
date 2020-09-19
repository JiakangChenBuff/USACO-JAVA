import java.util.*;
public class nqueen {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[][] board = new boolean[N][N];
        countQueens(board, 0);
        System.out.println(count);
        sc.close();
    }

    public static void countQueens(boolean[][] board, int row) {
        if (row >= board.length) {
            count++;
            return;
        }
        for (int c = 0; c < board.length; c++) {
            if (isSafe(board, row, c)) {
                board[row][c] = true;
                countQueens(board, row + 1);
                board[row][c] = false;
            }
        }
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        int r = row - 1;
        while (r >= 0) {
            if (board[r][col]) {
                return false;
            }
            r--;
        }
        r = row + 1;
        while (r < board.length) {
            if (board[r][col]) {
                return false;
            }
            r++;
        }
        int c = col - 1;
        while (c >= 0) {
            if (board[row][c]) {
                return false;
            }
            c--;
        }
        c = col + 1;
        while (c < board.length) {
            if (board[row][c]) {
                return false;
            }
            c++;
        }
        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c--;
        }
        r = row + 1;
        c = col + 1;
        while (r < board.length && c < board.length) {
            if (board[r][c]) {
                return false;
            }
            r++;
            c++;
        }
        r = row + 1;
        c = col - 1;
        while (r < board.length && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r++;
            c--;
        }
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board.length) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}
