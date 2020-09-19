import java.util.*;
public class mirror {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] bounce1 = {3, 2, 1, 0};
    static int[] bounce2 = {1, 0, 3, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] field = new String[N];
        for (int r = 0; r < N; r++) {
            field[r] = sc.nextLine();
        }
        int max = 0;
        for (int i = 0; i < M; i++) {
            int count1 = simulate(field, 0, i, 0);
            int count2 = simulate(field, N - 1, i, 2);
            max = Math.max(max, Math.max(count1, count2));
        }
        for (int i = 0; i < N; i++) {
            int count1 = simulate(field, i, 0, 1);
            int count2 = simulate(field, i, M - 1, 3);
            max = Math.max(max, Math.max(count1, count2));
        }
        System.out.println(max);
        sc.close();
    }

    private static int simulate(String[] field, int r, int c, int dir) {
        int result = 0;
        while (r >= 0 && r < field.length && c >= 0 && c < field[0].length()) {
            if (field[r].charAt(c) == '/') {
                dir = bounce1[dir];
            } else {
                dir = bounce2[dir];
            }
            r += dr[dir];
            c += dc[dir];
            result++;
        }
        return result;
    }
}
