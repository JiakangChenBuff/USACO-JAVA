import java.util.*;
public class profits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int prev = 0;
        for (int i = 1; i <= N; i++) {
            prev = Math.max(arr[i], arr[i] + prev);
            max = Math.max(max, prev);
        }
        System.out.println(max);
        sc.close();
    }
}
