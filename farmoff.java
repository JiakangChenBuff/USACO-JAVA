import java.util.*;
public class farmoff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();

        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long d = sc.nextInt();

        long e = sc.nextInt();
        long f = sc.nextInt();
        long g = sc.nextInt();
        long h = sc.nextInt();

        long M = sc.nextInt();

        int[][] cows = new int[3 * (int) N][2];
        for (int i = 0; i < 3 * N; i++) {
            cows[i][0] = (int) ((a * power(i, 5, d) + b * power(i, 2, d) + c) % d);
            cows[i][1] = (int) ((e * power(i, 5, h) + f * power(i, 3, h) + g) % h);
        }
        Arrays.sort(cows, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });
        long weights = 0;
        for (int i = 0; i < N; i++) {
            weights += cows[i][0];
        }
        System.out.println(weights % M);
        sc.close();
    }

    public static long power(long x, long y, long z) {
        long p = 1;
        for (int i = 1; i <= y; i++) {
            p = (p * x) % z;
        }
        return p;
    }
}
