import java.util.*;
public class maxcross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int B = sc.nextInt();
        int[] numBroken = new int[N + 1];
        boolean[] isBroken = new boolean[N + 1];
        for (int i = 0; i < B; i++) {
            isBroken[sc.nextInt()] = true;
        }
        for (int i = 1; i <= N; i++) {
            if (isBroken[i]) {
                numBroken[i] = numBroken[i - 1] + 1;
            } else {
                numBroken[i] = numBroken[i - 1];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            min = Math.min(min, numBroken[i] - numBroken[i - K]);
        }
        System.out.println(min);
        sc.close();
    }
}
