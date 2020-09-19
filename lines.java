import java.util.*;
public class lines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] points = new int[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        Set<Slope> S = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int n = points[j][1] - points[i][1];
                int d = points[j][0] - points[i][0];
                if (n == 0 || d == 0) {
                    if (n == 0) {
                        S.add(new Slope(0, 1));
                    } else {
                        S.add(new Slope(1, 0));
                    }
                } else {
                    int gcd;
                    if (n < 0 && d < 0) {
                        n = -n;
                        d = -d;
                        gcd = gcd(n, d);
                        n /= gcd;
                        d /= gcd;
                        S.add(new Slope(n, d));
                    } else if (n < 0) {
                        gcd = gcd(-n, d);
                        n /= gcd;
                        d /= gcd;
                        S.add(new Slope(n, d));
                    } else if (d < 0) {
                        gcd = gcd(n, -d);
                        n /= -gcd;
                        d /= -gcd;
                        S.add(new Slope(n, d));
                    } else {
                        gcd = gcd(n, d);
                        n /= gcd;
                        d /= gcd;
                        S.add(new Slope(n, d));
                    }
                }
            }
        }
        System.out.println(S.size());
        sc.close();
    }

    public static int gcd(int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (a == 0) {
            return b;
        } else {
            return gcd(b % a, a);
        }
    }
}

class Slope {
    public int n;
    public int d;

    public Slope(int n, int d) {
        this.n = n;
        this.d = d;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Slope)) {
            return false;
        }

        Slope otherSlope = (Slope) other;
        return this.n == otherSlope.n && this.d == otherSlope.d;
    }

    public int hashCode() {
        return Arrays.hashCode(new int[] {n, d});
    }
}