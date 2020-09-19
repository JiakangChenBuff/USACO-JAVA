import java.util.*;
public class cowjog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long T = sc.nextInt();
        long[] cows = new long[N];
        for (int i = 0; i < N; i++) {
            int pos = sc.nextInt();
            int speed = sc.nextInt();
            cows[i] = pos + T * speed;
        }
        int groups = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (cows[i] < cows[i + 1]) {
                groups++;
            } else {
                cows[i] = cows[i + 1];
            }
        }
        System.out.println(groups);
        sc.close();
    }
}
