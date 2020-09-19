import java.util.*;
public class bowls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = 0;
        for (int i = 0; i < 20; i++) {
            s += sc.nextInt() * (long) Math.pow(2, 19 - i);
        }

        int a = count(s, 20, 0);
        int b = count(s ^ (3 << 18), 20, 1);
        System.out.println(Math.min(a, b));
        sc.close();
    }

    public static int count(int num, int n, int count) {
        if (n == 1 && ((num & 1) == 0)) {
            return count;
        } else if (n == 1) {
            return Integer.MAX_VALUE;
        }
        if (num >> (n - 1) == 1) {
            if (n >= 3) {
                return count(num ^ (7 << (n - 3)), n - 1, count + 1);
            } else {
                return count(num ^ (7 >> (3 - n)), n - 1, count + 1);
            }
        } else {
            return count(num, n - 1, count);
        }
    }
}
