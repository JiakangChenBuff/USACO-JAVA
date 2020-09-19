import java.util.*;
public class stacking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] pf = new int[N - 1];
        int b = 0;
        for (int i = 0; i < 2 * K; i += 2) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            if (s == 0) {
                b++;
            }
            if (s - 1 >= 0) {
                pf[s - 1]++;
            }
            if (e < N - 1) {
                pf[e]--;
            }
        }
        int[] arr = new int[N];
        arr[0] = b;
        for (int i = 0; i < N - 1; i++) {
            arr[i + 1] = arr[i] + pf[i];
        }
        Arrays.sort(arr);
        System.out.println(arr[(arr.length - 1) / 2]);
        sc.close();
    }
}
