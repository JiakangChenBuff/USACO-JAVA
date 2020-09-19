import java.util.*;
public class cowids {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] ans = null;
        for (int i = K; i > 0; i--) {
            int n = i;
            while (combo(n, i) < N) {
                n++;
            }
            if (ans == null) {
                ans = new int[n];
            }
            ans[ans.length - n] = 1;
            N -= combo(n - 1, i);
        }
        for (int i : ans) {
            System.out.print(i);
        }
        System.out.println();
        sc.close();
    }

    public static int combo(int n, int k) {
        long ans = 1;
        for (int i = 0; i < k; i++) {
            ans *= (n - i);
        }
        for (int i = k; i >= 1; i--) {
            ans /= i;
        }
        return (int) ans;
    }
}
