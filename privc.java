import java.util.*;
public class privc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cows = new int[N];
        int[] counts = new int[4];
        for (int i = 0; i < N; i++) {
            cows[i] = sc.nextInt();
            counts[cows[i]]++;
        }
        int[][] range = new int[4][2];
        range[1][0] = 0;
        range[1][1] = counts[1] - 1;
        range[2][0] = counts[1];
        range[2][1] = counts[1] + counts[2] - 1;
        range[3][0] = counts[1] + counts[2];
        range[3][1] = N - 1;
        int ans = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = range[i][0]; j <= range[i][1]; j++) {
                if (cows[j] != i) {
                    ans++;
                    int ind1 = -1;
                    int ind2 = -1;
                    for (int k = range[cows[j]][0]; k <= range[cows[j]][1]; k++) {
                        if (cows[k] == i) {
                            ind1 = k;
                            break;
                        } else if (cows[k] != cows[j]) {
                            ind2 = k;
                        }
                    }
                    if (ind1 != -1) {
                        int tmp = cows[j];
                        cows[j] = cows[ind1];
                        cows[ind1] = tmp;
                    } else {
                        int tmp = cows[j];
                        cows[j] = cows[ind2];
                        cows[ind2] = tmp;
                    }
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
