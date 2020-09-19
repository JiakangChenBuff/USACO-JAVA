import java.util.*;
public class teststr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] kVal = new int[K];
        for (int i = 0; i < K; i++) {
            kVal[i] = sc.nextInt();
        }
        Arrays.sort(kVal);
        int max = 0;
        for (int i = 0; i <= N; i++) {
            int targetK = N - i;
            int lowInd = upper(kVal, targetK);
            int upInd = lower(kVal, targetK);
            if (lowInd < 0) {
                max = Math.max(max, kVal[upInd] - targetK);
            } else if (upInd >= K) {
                max = Math.max(max, targetK - kVal[lowInd]);
            } else {
                max = Math.max(max, Math.min(targetK - kVal[lowInd], kVal[upInd] - targetK));
            }
        }
        System.out.println(max);
        sc.close();
    }

    public static int upper(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static int lower(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
