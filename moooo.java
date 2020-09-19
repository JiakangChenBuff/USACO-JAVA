import java.util.*;
public class moooo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] cows = new int[N][2]; // [0] is height & [1] is volume
        for (int i = 0; i < N; i++) {
            cows[i][0] = sc.nextInt();
            cows[i][1] = sc.nextInt();
        }

        int[] volumes = new int[N];
        Stack<int[]> S = new Stack<>();
        for (int i = 0; i < N; i++) {
            int currV = 0;
            while (S.size() > 0 && cows[i][0] > S.peek()[0]) {
                currV += S.pop()[1];
            }
            volumes[i] += currV;
            S.push(cows[i]);
        }

        S = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            int currV = 0;
            while (S.size() > 0 && cows[i][0] > S.peek()[0]) {
                currV += S.pop()[1];
            }
            volumes[i] += currV;
            S.push(cows[i]);
        }

        int maxV = 0;
        for (int i = 0; i < N; i++) {
            maxV = Math.max(maxV, volumes[i]);
        }
        System.out.println(maxV);
        sc.close();
    }
}
