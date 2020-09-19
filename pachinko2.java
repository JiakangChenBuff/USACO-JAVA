import java.util.*;
public class pachinko2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int[][] val = new int[R][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j <= i; j++) {
                val[i][j] = sc.nextInt();
            }
        }
        for (int i = R - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                val[i][j] += Math.max(val[i + 1][j], val[i + 1][j + 1]);
            }
        }
        System.out.println(val[0][0]);
        sc.close();
    }
}
