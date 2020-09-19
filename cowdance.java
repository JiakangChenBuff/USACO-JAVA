import java.util.*;
public class cowdance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int TMax = sc.nextInt();
        int[] cowTimes = new int[N];
        for (int i = 0; i < N; i++) {
            cowTimes[i] = sc.nextInt();
        }

        int low = 1;
        int high = N;
        while (low <= high) {
            int K = (low + high) / 2;
            PriorityQueue<Integer> Q = new PriorityQueue<>();
            int i = 0;
            for (; i < K; i++) {
                Q.add(cowTimes[i]);
            }
            int T = 0;
            while (!Q.isEmpty()) {
                if (i < N) {
                    int curr = Q.poll();
                    Q.add(cowTimes[i] + curr);
                    i++;
                } else {
                    T = Q.poll();
                }
            }
            if (T > TMax) {
                low = K + 1;
            } else {
                high = K - 1;
            }
        }
        System.out.println(low);
        sc.close();
    }
}
