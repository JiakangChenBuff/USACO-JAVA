import java.util.*;
public class diet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int N = sc.nextInt();
        int[] weights = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            weights[i] = sc.nextInt();
        }
        int[] prev = new int[H + 1];
        for (int i = 1; i <= N; i++) {
            int[] curr = new int[H + 1];
            for (int j = 1; j <= H; j++) {
                if (j - weights[i] >= 0) {
                    curr[j] = Math.max(prev[j], weights[i] + prev[j - weights[i]]);
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        System.out.println(prev[H]);
        sc.close();
    }
}
