import java.util.*;
public class dance2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] KS = new int[N];
        String[] PS = new String[N];
        for (int i = 0; i < N; i++) {
            KS[i] = sc.nextInt();
            PS[i] = sc.next();
        }
        for (int i = 0; i < N; i++) {
            int K = KS[i];
            String P = PS[i];
            int L = 0;
            int R = 0;
            boolean legal = true;
            for (int j = 0; j < K; j++) {
                if (P.substring(j, j + 1).equals(">")) {
                    L++;
                } else {
                    R++;
                }
                if (R > L) {
                    legal = false;
                }
            }
            if (legal && L == R) {
                System.out.println("legal");
            } else {
                System.out.println("illegal");
            }
        }
        sc.close();
    }
}
