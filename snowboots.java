import java.util.*;
public class snowboots {
    public static int best = 9999;
    public static int N;
    public static int B;
    public static int[] snow;
    public static int[][] boots;
    public static boolean[][] seen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = sc.nextInt();
        snow = new int[N];
        for (int i = 0; i < N; i++) {
            snow[i] = sc.nextInt();
        }
        boots = new int[B][2];
        for (int i = 0; i < B; i++) {
            boots[i][0] = sc.nextInt();
            boots[i][1] = sc.nextInt();
        }
        seen = new boolean[N][B];
        visit(0, 0);
        System.out.println(best);
        sc.close();
    }

    public static void visit(int i, int b) {
        if (seen[i][b]) {
            return;
        }

        seen[i][b] = true;

        if (i == N - 1) {
            best = Math.min(best, b);
            return;
        }

        for (int j = i + 1; j < N && j <= i + boots[b][1]; j++) {
            if (snow[j] <= boots[b][0]) {
                visit(j, b);
            }
        }

        for (int j = b + 1; j < B; j++) {
            if (snow[i] <= boots[j][0]) {
                visit(i, j);
            }
        }
    }
}
