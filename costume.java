import java.util.*;
public class costume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int curr = arr[i];
            boolean flag = false;
            if (2 * curr <= S) {
                flag = true;
            }
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] + curr > S) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            int temp = low;
            if (flag) {
                temp--;
            }
            count += temp;
        }
        System.out.println(count / 2);
        sc.close();
    }
}
