import java.util.*;
public class sudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                grid[r][c] = sc.nextInt();
            }
        }

        if (solveSudoku(grid)) {
            for (int[] arr : grid) {
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("NO SOLUTION");
        }
        sc.close();
    }

    public static boolean solveSudoku(int[][] grid) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        outer:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;

                    isEmpty = false;
                    break outer;
                }
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;
                if (solveSudoku(grid)) {
                    return true;
                } else {
                    grid[row][col] = 0;
                }
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] grid, int row, int col, int num) {
        for (int c = 0; c < 9; c++) {
            if (c != col && grid[row][c] == num) {
                return false;
            }
        }

        for (int r = 0; r < 9; r++) {
            if (r != row && grid[r][col] == num) {
                return false;
            }
        }

        int[] cols = new int[3];
        int[] rows = new int[3];
        if (row % 3 == 0) {
            rows[0] = row; rows[1] = row + 1; rows[2] = row + 2;
        } else if (row % 3 == 1) {
            rows[0] = row - 1; rows[1] = row; rows[2] = row + 1;
        } else {
            rows[0] = row - 2; rows[1] = row - 1; rows[2] = row;
        }
        if (col % 3 == 0) {
            cols[0] = col; cols[1] = col + 1; cols[2] = col + 2;
        } else if (col % 3 == 1) {
            cols[0] = col - 1; cols[1] = col; cols[2] = col + 1;
        } else {
            cols[0] = col - 2; cols[1] = col - 1; cols[2] = col;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (rows[i] != row && cols[j] != col && grid[rows[i]][cols[j]] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
