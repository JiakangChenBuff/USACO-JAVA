import java.util.*;
public class combo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int f1 = sc.nextInt();
        int f2 = sc.nextInt();
        int f3 = sc.nextInt();
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int count = 0;
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                for (int c = 1; c <= N; c++) {
                    if (isValid(a, b, c, f1, f2, f3, N)) {
                        count++;
                    } else if (isValid(a, b, c, m1, m2, m3, N)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static boolean isValid(int a, int b, int c, int d, int e, int f, int N) {
        return isEqual(a, d, N) && isEqual(b, e, N) && isEqual(c, f, N);
    }

    public static boolean isEqual(int a, int b, int N) {
        return (a == b || map(a , 1, N) == b || map(a, 2, N) == b || map(a, -1, N) == b || map(a, -2, N) == b);
    }

    public static int map(int a, int amount, int N) {
        if (a + amount == 0) {
            return N;
        } else if (a + amount == -1) {
            return N - 1;
        } else if (a + amount == N + 1) {
            return 1;
        } else if (a + amount == N + 2) {
            return 2;
        } else {
            return a + amount;
        }
    }
}
