import java.util.*;
public class badrand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int[] arr = new int[10002];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (inArr(N, arr)) {
                break;
            } else {
                count++;
                arr[i] = N;
            }
            N %= 1000;
            N /= 10;
            N = (int) Math.pow(N, 2);
        }
        System.out.println(count);
        sc.close();
    }

    public static boolean inArr(int N, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == N) {
                return true;
            }
        }
        return false;
    }
}
