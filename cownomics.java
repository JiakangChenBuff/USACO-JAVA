import java.util.*;
public class cownomics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] spot = new String[N];
        String[] plain = new String[N];
        for (int i = 0; i < N; i++) {
            spot[i] = sc.nextLine();
        }
        for (int i = 0; i < N; i++) {
            plain[i] = sc.nextLine();
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    boolean[] vis = new boolean[64];
                    for (int l = 0; l < N; l++) {
                        vis[16 * map(plain[l].substring(i, i + 1)) + 4 * map(plain[l].substring(j, j + 1)) + map(plain[l].substring(k, k + 1))] = true;
                    }
                    boolean isDup = false;
                    for (int l = 0; l < N; l++) {
                        if (vis[16 * map(spot[l].substring(i, i + 1)) + 4 * map(spot[l].substring(j, j + 1)) + map(spot[l].substring(k, k + 1))]) {
                            isDup = true;
                            break;
                        }
                    }
                    if (!isDup) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static int map(String letter) {
        if (letter.equals("A")) {
            return 0;
        } else if (letter.equals("T")) {
            return 1;
        } else if (letter.equals("C")) {
            return 2;
        } else {
            return 3;
        }
    }
}
