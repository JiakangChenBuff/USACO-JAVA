import java.util.*;
public class reorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        int count = 0;
        int longest = -1;
        for (int i = 0; i < N; i++) {
            if (A[i] != B[i]) {
                count++;
                int length = 1;
                int start = i;
                int next = where(A[i], B);
                int prev = A[i];
                while (start != next) {
                    length++;
                    int temp = A[next];
                    A[next] = prev;
                    prev = temp;
                    next = where(temp, B);
                }
                A[start] = A[next];
                longest = Math.max(longest, length);
            }
        }
        System.out.println(count + " " + longest);
        sc.close();
    }

    public static int where(int x, int[] B) {
        int result = -1;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == x) {
                result = i;
                break;
            }
        }
        return result;
    }
}
