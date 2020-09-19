import java.util.*;
public class scales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(recurse(arr, N - 1, C));
        sc.close();
    }

    public static int recurse(int[] arr, int N, int C) {
        if (N == 0) {
            if (arr[0] > C) {
                return 0;
            } else {
                return arr[0];
            }
        } else if (N < 0) {
            return 0;
        } else {
            if (arr[N - 1] + arr[N] <= C) {
                return arr[N] + recurse(arr, N - 1, C - arr[N]);
            } else if (arr[N] <= C) {
                return Math.max(arr[N] + recurse(arr, N - 2, C - arr[N]), arr[N - 1] + recurse(arr, N - 2, C - arr[N - 1]));
            } else {
                return recurse(arr, N - 1, C);
            }
        }
    }
}
