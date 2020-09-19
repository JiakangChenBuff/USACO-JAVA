import java.util.*;
public class wordpow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = sc.nextLine().toLowerCase();
        }
        String[] good = new String[M];
        for (int i = 0; i < M; i++) {
            good[i] = sc.nextLine().toLowerCase();
        }
        for (int i = 0; i < N; i++) {
            int ans = 0;
            for (int j = 0; j < M; j++) {
                int goodInd = 0;
                for (int k = 0; k < names[i].length(); k++) {
                    if (names[i].charAt(k) == good[j].charAt(goodInd)) {
                        goodInd++;
                    }
                    if (goodInd == good[j].length()) {
                        ans++;
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
