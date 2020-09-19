import java.util.*;
public class cbuying {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long B = sc.nextLong();
        long[][] chocolates = new long[N][2];
        for (int i = 0; i < N; i++) {
            chocolates[i][0] = sc.nextLong();
            chocolates[i][1] = sc.nextLong();
        }
        Arrays.sort(chocolates, new Comparator<long[]>() {
            public int compare(long[] a, long[] b) {
                return Long.compare(a[0], b[0]);
            }
        });
        long cows = 0;
        for (int i = 0; i < N; i++) {
            long chocCount = Math.min((B / chocolates[i][0]), chocolates[i][1]);
            cows += chocCount;
            B -= (chocCount * chocolates[i][0]);
        }
        System.out.println(cows);
        sc.close();
    }
}
