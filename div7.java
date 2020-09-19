import java.util.*;
public class div7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ps = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            ps[i] = (ps[i - 1] + sc.nextInt() % 7) % 7;
        }
        boolean[] firstVis = new boolean[7];
        int[] firstIndex = new int[7];
        for (int i = 0; i < N + 1; i++) {
            if (!firstVis[ps[i]]) {
                firstVis[ps[i]] = true;
                firstIndex[ps[i]] = i;
            }
        }
        boolean[] lastVis = new boolean[7];
        int[] lastIndex = new int[7];
        for (int i = N; i >= 0; i--) {
            if (!lastVis[ps[i]]) {
                lastVis[ps[i]] = true;
                lastIndex[ps[i]] = i;
            }
        }
        int[] dif = new int[7];
        for (int i = 0; i < 7; i++) {
            dif[i] = lastIndex[i] - firstIndex[i];
        }
        Arrays.sort(dif);
        System.out.println(dif[6]);
        sc.close();
    }
}
