import java.util.*;
public class poker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = arr[0] + arr[N - 1];
        for (int i = 1; i < N; i++) {
            sum += Math.abs(arr[i] - arr[i - 1]);
        }
        System.out.println(sum / 2);
        sc.close();
    }
}
