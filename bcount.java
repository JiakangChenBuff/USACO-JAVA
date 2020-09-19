import java.util.*;
public class bcount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[][] ps = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            if (x == 1) {
                ps[i][0] = ps[i - 1][0] + 1;
                ps[i][1] = ps[i - 1][1];
                ps[i][2] = ps[i - 1][2];
            } else if (x == 2) {
                ps[i][0] = ps[i - 1][0];
                ps[i][1] = ps[i - 1][1] + 1;
                ps[i][2] = ps[i - 1][2];
            } else {
                ps[i][0] = ps[i - 1][0];
                ps[i][1] = ps[i - 1][1];
                ps[i][2] = ps[i - 1][2] + 1;
            }
        }
        for (int i = 0; i < Q; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt();
            System.out.println((ps[b][0] - ps[a][0]) + " " + (ps[b][1] - ps[a][1]) + " " + (ps[b][2] - ps[a][2]));
        }
        sc.close();
    }
}
