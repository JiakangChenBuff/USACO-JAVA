import java.util.*;
public class numgrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[5][5];
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                grid[r][c] = sc.nextInt();
            }
        }

        int[][] moveSet = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Set<Integer> ans = new HashSet<Integer>();
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                int res = grid[r][c];
                for (int i = 0; i < 1024; i++) {
                    int tmp = res;
                    int tR = r;
                    int tC = c;
                    int[] moves = new int[5];
                    int j = 4;
                    int k = i;
                    while (k > 0) {
                        moves[j] = k % 4;
                        k /= 4;
                        j--;
                    }
                    boolean failed = false;
                    for (j = 0; j < 5; j++) {
                        tR += moveSet[moves[j]][0];
                        tC += moveSet[moves[j]][1];
                        if (tR < 0 || tR > 4 || tC < 0 || tC > 4) {
                            failed = true;
                            break;
                        } else {
                            tmp *= 10;
                            tmp += grid[tR][tC];
                        }
                    }
                    if (!failed) {
                        ans.add(tmp);
                    }
                }
            }
        }
        System.out.println(ans.size());
        sc.close();
    }
}
