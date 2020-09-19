import java.util.*;
public class haybales2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] hay = new int[N + 1];
        hay[N] = -1;
        for (int i = 0; i < N; i++) {
            hay[i] = sc.nextInt();
        }
        Arrays.sort(hay);
        for (int i = 0; i < Q; i++) {
            int A = sc.nextInt();
            int aLow = 0;
            int aHigh = N;
            while (aLow <= aHigh) {
                int mid = (aLow + aHigh) / 2;
                if (hay[mid] >= A) {
                    aHigh = mid - 1;
                } else {
                    aLow = mid + 1;
                }
            }
            int B = sc.nextInt();
            int bLow = 0;
            int bHigh = N;
            while (bLow <= bHigh) {
                int mid = (bLow + bHigh) / 2;
                if (hay[mid] > B) {
                    bHigh = mid - 1;
                } else {
                    bLow = mid + 1;
                }
            }
            System.out.println(bHigh - aHigh);
        }
        sc.close();
    }
}
