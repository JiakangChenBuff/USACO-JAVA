import java.util.*;
public class msort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, N - 1);
        sc.close();
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        mergeSort(arr, left, (right + left) / 2);
        mergeSort(arr, (right + left) / 2 + 1 , right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int left, int right) {
        int[] tmp = new int[right - left + 1];
        int[] leftArr = Arrays.copyOfRange(arr, left, (right + left) / 2 + 1);
        int[] rightArr = Arrays.copyOfRange(arr, (right + left) / 2 + 1, right + 1);

        int lIndex = 0;
        int rIndex = 0;
        int tmpIndex = 0;
        while (lIndex < leftArr.length && rIndex < rightArr.length) {
            if (leftArr[lIndex] < rightArr[rIndex]) {
                tmp[tmpIndex] = leftArr[lIndex];
                lIndex++;
            } else {
                tmp[tmpIndex] = rightArr[rIndex];
                rIndex++;
            }
            tmpIndex++;
        }
        while (lIndex < leftArr.length) {
            tmp[tmpIndex] = leftArr[lIndex];
            lIndex++;
            tmpIndex++;
        }
        while (rIndex < rightArr.length) {
            tmp[tmpIndex] = rightArr[rIndex];
            rIndex++;
            tmpIndex++;
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i - left];
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
