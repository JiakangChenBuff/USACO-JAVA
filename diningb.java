import java.util.*;
public class diningb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        int[] a = new int[N + 1];
        a[0] = 0;
        for (int i = 0; i < N; i++) {
            if (num[i] == 1) {
                a[i + 1] = a[i] + 1;
            } else {
                a[i + 1] = a[i];
            }
        }
        int[] b = new int[N + 1];
        b[0] = 0;
        for (int i = 0; i < N; i++) {
            if (num[i] == 1) {
                b[i + 1] = b[i];
            } else {
                b[i + 1] = b[i] + 1;
            }
        }
        int min = Math.min(a[N] - a[0], b[N] - b[0]);
        for (int i = 0; i < N - 1; i++) {
            int count = 0;
            count += (b[i + 1] - b[0]);
            count += (a[N] - a[i + 1]);
            min = Math.min(min, count);
        }
        System.out.println(min);
        sc.close();
    }
}
