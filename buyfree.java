import java.util.*;
public class buyfree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] H = new int[N];
        int[] L = new int[M];
        for (int i = 0; i < N; i++) {
            H[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            L[i] = sc.nextInt();
        }
        Arrays.sort(H);
        Arrays.sort(L);
        int count = N;
        int j = M - 1;
        for (int i = N - 1; i >= 0; i--) {
            for ( ; j >= 0; j--) {
                if (L[j] < H[i]) {
                    count++;
                    j--;
                    break;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
