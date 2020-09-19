import java.util.*;
public class subset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N % 4 == 3 || N % 4 == 0) {
            int target = N * (N + 1) / 4;
            long[] prev = new long[target + 1];
            prev[0] = 1;
            for (int i = 1; i <= N; i++) {
                long[] ans = new long[target + 1];
                for (int j = 0; j <= target; j++) {
                    ans[j] = (j - i >= 0) ? prev[j] + prev[j - i] : prev[j];
                }
                prev = ans;
            }
            System.out.println(prev[target] / 2);
        } else {
            System.out.println(0);
        }
        sc.close();
    }
}
