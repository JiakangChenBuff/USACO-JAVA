import java.util.*;
public class lookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] A = new int[N];
        Stack<Integer> I = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            while (I.size() != 0) {
                int x = I.peek();
                if (arr[i] > arr[x]) {
                    A[x] = i + 1;
                    I.pop();
                } else {
                    break;
                }
            }
            I.push(i);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
        sc.close();
    }
}
