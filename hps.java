import java.util.*;
public class hps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = map(sc.next());
        }
        int[][] prev = new int[K + 1][3];
        for (int i = 1; i <= N; i++) {
            int[][] curr = new int[K + 1][3];
            for (int j = 0; j <= K; j++) {
                for (int k = 0; k < 3; k++) {
                    int add = (arr[i] == k) ? 1 : 0;
                    if (j > 0) {
                        curr[j][k] = Math.max(prev[j][k] + add, Math.max(prev[j - 1][(k + 1) % 3] + add, prev[j - 1][(k + 2) % 3] + add));
                    } else {
                        curr[j][k] = prev[j][k] + add;
                    }
                }
            }
            prev = curr;
        }
        System.out.println(Math.max(prev[K][0], Math.max(prev[K][1], prev[K][2])));
        sc.close();
    }

    public static int map(String str) {
        switch(str) {
            case "H":
                return 0;
            case "P":
                return 1;
            default:
                return 2;
        }
    }
}
