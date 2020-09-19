import java.util.*;
public class mmind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] G = new int[N];
        int[] C = new int[N];
        int[] W = new int[N];
        for (int i = 0; i < N; i++) {
            G[i] = sc.nextInt();
            C[i] = sc.nextInt();
            W[i] = sc.nextInt();
        }
        sc.close();
        int i = 1000;
        boolean exists = false;
        for ( ; i <= 9999; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                int c = 0;
                int w = 0;
                String T = Integer.toString(G[j]);
                boolean[] used = new boolean[4];
                for (int k = 0; k < 4; k++) {
                    String d = Integer.toString(i).substring(k, k + 1);
                    if (d.equals(T.substring(k, k + 1)) && !used[k]) {
                        used[k] = true;
                        c++;
                    }
                }
                for (int k = 0; k < 4; k++) {
                    String d = Integer.toString(i).substring(k, k + 1);
                    if (!used[k]) {
                        for (int m = 0; m < 4; m++) {
                            if (m != k) {
                                if (d.equals(T.substring(m, m + 1)) && !used[m]) {
                                    used[m] = true;
                                    w++;
                                }
                            }
                        }
                    }
                }
                if (c == C[j] && w == W[j]) {
                    count++;
                }
            }
            if (count == N) {
                exists = true;
                break;
            }
        }
        if (exists) {
            System.out.println(i);
        } else {
            System.out.println("NONE");
        }
    }
}
