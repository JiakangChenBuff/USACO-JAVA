import java.util.*;
public class paint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] crit = new int[N + 1];
        crit[0] = 0;
        int[] s = new int[N];
        int[] e = new int[N];
        for (int i = 1; i < N + 1; i++) {
            int x = sc.nextInt();
            String I = sc.next();
            if (I.equals("R")) {
                crit[i] = crit[i - 1] + x;
            } else {
                crit[i] = crit[i - 1] - x;
            }
            s[i - 1] = Math.min(crit[i - 1], crit[i]);
            e[i - 1] = Math.max(crit[i - 1], crit[i]);
        }
        Arrays.sort(crit);
        int[] PS = new int[N];
        for (int i = 0; i < N; i++) {
            int S = s[i];
            int sI = -1;
            int l = 0;
            int h = N;
            while (l <= h) {
                int m = (l + h) / 2;
                if (crit[m] == S) {
                    sI = m;
                    break;
                } else if (crit[m] > S) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
            int E = e[i];
            int eI = -1;
            l = 0;
            h = N;
            while (l <= h) {
                int m = (l + h) / 2;
                if (crit[m] == E) {
                    eI = m;
                    break;
                } else if (crit[m] > E) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
            if (sI != N) {
                PS[sI]++;
            }
            if (eI != N) {
                PS[eI]--;
            }
        }
        int[] ans = new int[N];
        ans[0] = PS[0];
        for (int i = 1; i < N; i++) {
            ans[i] = ans[i - 1] + PS[i];
        }
        int counter = 0;
        for (int i = 0; i < N; i++) {
            if (ans[i] >= 2) {
                counter += (crit[i + 1] - crit[i]);
            }
        }
        System.out.println(counter);
        sc.close();
    }
}
