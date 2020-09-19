import java.util.*;
public class banner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int L1 = sc.nextInt();
        int L2 = sc.nextInt();
        long count = 0;
        for (int i = 0; i <= H; i++) {
            for (int j = 0; j <= W; j++) {
                int small = Math.min(i, j);
                int large = Math.max(i, j);
                if ((int) Math.pow(i, 2) + (int) Math.pow(j, 2) >= (int) Math.pow(L1, 2) && (int) Math.pow(i, 2) + (int) Math.pow(j, 2) <= Math.pow(L2, 2) && gcd(small, large) == 1) {
                    if (small == 0) {
                        count += (H - i + 1) * (W - j + 1);
                    } else {
                        count += (H - i + 1) * (W - j + 1) * 2;
                    }
                }
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return gcd(b % a, a);
        }
    }
}
