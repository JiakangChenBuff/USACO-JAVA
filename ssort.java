import java.util.*;
public class ssort {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[(int) Math.pow(2, N)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        skewedSort(arr, 0, arr.length - 1);
        System.out.println(count);
        for (int num : arr) {
            System.out.println(num);
        }
        sc.close();
    }

    public static void skewedSort(int[] arr, int s, int e) {
        if (s == e) {
            return;
        }

        skewedSort(arr, s, (s + e) / 2);
        skewedSort(arr, (s + e) / 2 + 1, e);

        swap(arr, s, e);
    }

    public static void swap(int[] arr, int s, int e) {
        boolean toSwap = false;
        int j = (s + e) / 2 + 1;
        for (int i = s; i <= (s + e) / 2; i++) {
            if (arr[i] > arr[j]) {
                toSwap = true;
                break;
            } else if (arr[i] < arr[j]) {
                break;
            }
            j++;
        }
        if (toSwap) {
            j = (s + e) / 2 + 1;
            count += (e - s + 1) * (j - s);
            for (int i = s; i <= (s + e) / 2; i++) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }
    }
}
