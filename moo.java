import java.util.*;
public class moo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[28];
        int i = 0;
        int prev = 0;
        while (prev <= 1000000000) {
            arr[i] = 2 * prev + (i + 3);
            prev = arr[i];
            i++;
        }

        int N = sc.nextInt() - 1;
        i = 0;
        while (N > arr[i]) {
            i++;
        }
        boolean found = false;
        while (i != 0) {
            if (N >= arr[i - 1] + i + 3) {
                N -= (arr[i - 1] + i + 3);
                i--;
            } else if (N >= arr[i - 1]) {
                System.out.println(N == arr[i - 1] ? "m" : "o");
                found = true;
                break;
            } else {
                i--;
            }
        }
        if (!found) {
            System.out.println(N % 3 == 0 ? "m" : "o");
        }
        sc.close();
    }
}
