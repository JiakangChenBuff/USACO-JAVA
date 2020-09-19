import java.util.*;
public class qsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        quicksort(arr, 0, N - 1);
        sc.close();
    }

    public static void quicksort(int[] arr, int left, int right) {
        if (right - left > 0) {
            int pivot = arr[right];
            int partition = partition(arr, left, right, pivot);
            quicksort(arr, left, partition - 1);
            quicksort(arr, partition + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right, int pivot) {
        int leftPointer = left;
        int rightPointer = right - 1;

        while (true) {
            while (leftPointer < arr.length && arr[leftPointer] < pivot) {
                leftPointer++;
            }

            while (rightPointer >= 0 && arr[rightPointer] > pivot) {
                rightPointer--;
            }

            if (leftPointer >= rightPointer) {
                break;
            } else {
                swap(arr, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }

        swap(arr, leftPointer, right);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        return leftPointer;
    }

    public static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
