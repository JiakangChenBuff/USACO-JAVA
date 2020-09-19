import java.util.*;
public class dna2 {
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }

        permute(arr, N);
        System.out.println(min);
        sc.close();
    }

    public static void permute(String[] arr, int N) {
        if (N == 1) {
            String str = arr[0];
            for (int i = 1; i < arr.length; i++) {
                str = combine(str, arr[i]);
            }
            min = Math.min(min, str.length());
        } else {
            for (int i = 0; i < N - 1; i++) {
                permute(arr, N - 1);
                if (N % 2 == 0) {
                    String tmp = arr[i];
                    arr[i] = arr[N - 1];
                    arr[N - 1] = tmp;
                } else {
                    String tmp = arr[0];
                    arr[0] = arr[N - 1];
                    arr[N - 1] = tmp;
                }
            }
            permute(arr, N - 1);
        }
    }

    public static String combine(String s1, String s2) {
        int i;
        for (i = 0; i < s1.length(); i++) {
            if (s2.indexOf(s1.substring(i)) == 0) {
                break;
            }
        }
        return s1 + s2.substring(s1.length() - i);
    }
}
