import java.util.*;
public class fliptile {
    public static int[] dr = {0, -1, 0};
    public static int[] dc = {-1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] init = new int[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                init[r][c] = sc.nextInt();
            }
        }

        int[][] sol = new int[M][N];
        int flipCount = Integer.MAX_VALUE;
        TopRow curr = new TopRow(N);
        boolean found = false;
        for (int i = 0; i < (int) Math.pow(2, N); i++) {
            int[][] tmp = new int[M][N];
            tmp[0] = curr.row;

            for (int r = 1; r < M; r++) {
                for (int c = 0; c < N; c++) {
                    int sum = tmp[r - 1][c];
                    for (int j = 0; j < 3; j++) {
                        if (r - 1 + dr[j] >= 0 && c + dc[j] >= 0 && c + dc[j] < N) {
                            sum += tmp[r - 1 + dr[j]][c + dc[j]];
                        }
                    }
                    tmp[r][c] = Math.abs(init[r - 1][c] - (sum % 2));
                }
            }

            boolean works = true;
            for (int c = 0; c < N; c++) {
                int sum = tmp[M - 1][c];
                for (int j = 0; j < 3; j++) {
                    if (M - 1 + dr[j] >= 0 && c + dc[j] >= 0 && c + dc[j] < N) {
                        sum += tmp[M - 1 + dr[j]][c + dc[j]];
                    }
                }
                if (sum % 2 != init[M - 1][c]) {
                    works = false;
                    break;
                }
            }

            if (works) {
                found = true;

                int tmpCount = 0;
                for (int r = 0; r < M; r++) {
                    for (int c = 0; c < N; c++) {
                        if (tmp[r][c] == 1) {
                            tmpCount++;
                        }
                    }
                }
                if (tmpCount < flipCount) {
                    flipCount = tmpCount;
                    for (int r = 0; r < M; r++) {
                        for (int c = 0; c < N; c++) {
                            sol[r][c] = tmp[r][c];
                        }
                    }
                }
            }

            curr.add();
        }

        if (found) {
            for (int r = 0; r < M; r++) {
                for (int c = 0; c < N; c++) {
                    System.out.print(sol[r][c] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
        sc.close();
    }
}

class TopRow {
    public int[] row;

    public TopRow(int N) {
        row = new int[N];
    }

    public void add() {
        int i = row.length - 1;
        while (i != -1 && row[i] == 1) {
            row[i] = 0;
            i--;
        }
        if (i != -1) {
            row[i] = 1;
        }
    }
}
