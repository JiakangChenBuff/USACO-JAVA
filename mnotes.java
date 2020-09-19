import java.util.*;
public class mnotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] arr = new int[2 * N];
        int index = 0;
        for (int i = 0; i < 2 * N; i += 2) {
            int x = sc.nextInt();
            arr[i] = index;
            arr[i + 1] = index + x - 1;
            index += x;
        }
        for (int i = 0; i < Q; i++) {
            int t = sc.nextInt();
            System.out.println(find(t, arr) / 2 + 1);
        }
        sc.close();
    }

    public static int find(int t, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == t) {
                low = mid;
                break;
            } else if (arr[mid] > t) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
