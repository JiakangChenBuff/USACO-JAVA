import java.util.*;
public class haybales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] haybales = new int[N];
        for (int i = 0; i < N; i++) {
            haybales[i] = sc.nextInt();
        }
        Arrays.sort(haybales);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += haybales[i];
        }
        int A = sum / N;
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += (Math.abs(A - haybales[i]));
        }
        System.out.println(count / 2);
        sc.close();
    }
}
