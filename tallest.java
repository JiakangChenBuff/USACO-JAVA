import java.util.*;
public class tallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextInt();
        int H = sc.nextInt();
        int R = sc.nextInt();

        Set<TallestPair> S = new HashSet<>();

        int[][] cows = new int[N][2];
        for (int i = 0; i < R; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            if (!S.contains(new TallestPair(a, b))) {
                cows[a][0]++;
                cows[b][1]++;
                S.add(new TallestPair(a, b));
            }
        }

        int[] ans = new int[N];
        int seeCount = 0;
        for (int i = 0; i < N; i++) {
            seeCount -= cows[i][1];
            ans[i] = H - seeCount;
            seeCount += cows[i][0];
        }
        for (int i = 0; i < N; i++) {
            System.out.println(ans[i]);
        }
        sc.close();
    }
}

class TallestPair {
    public int a;
    public int b;

    public TallestPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof TallestPair)) {
            return false;
        }

        TallestPair otherPair = (TallestPair) other;
        return this.a == otherPair.a && this.b == otherPair.b;
    }

    public int hashCode() {
        int[] tmp = new int[] {a, b};
        return Arrays.hashCode(tmp);
    }
}
