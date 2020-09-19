import java.util.*;
public class binarysearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < Q; i++) {
            System.out.println(find(sc.nextInt(), arr));
        }
        sc.close();
    }

    public static int find(int x, int[] arr) {
        int index = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                index = mid;
                break;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        for (int i = 0; i < 15; i++) {
            low = 0;
            high = index - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == x) {
                    index = mid;
                    break;
                } else if (arr[mid] > x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return index;
    }
}
