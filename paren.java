import java.util.*;
public class paren {
    public static long mod = 12345678910L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] levels = new long[N + 1];
        boolean[] arr = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt() == 0;
        }
        int level = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i]) {
                level++;
                if (!arr[i + 1]) {
                    level--;
                    levels[level] = (levels[level] + 1) % mod;
                    i++;
                }
            } else {
                level--;
                levels[level] = (levels[level] + 2 * levels[level + 1]) % mod;
                levels[level + 1] = 0;
            }
        }
        System.out.println(levels[1]);
        sc.close();
    }
}
