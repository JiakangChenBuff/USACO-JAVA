import java.util.*;
public class racing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int T = sc.nextInt();
        int U = sc.nextInt();
        int F = sc.nextInt();
        int D = sc.nextInt();
        sc.nextLine();
        String[] P = new String[T];
        for (int i = 0; i < T; i++) {
            P[i] = sc.nextLine();
        }
        sc.close();
        int[] dis = new int[T + 1];
        for (int i = 1; i < T + 1; i++) {
            if (P[i - 1].equals("u") || P[i - 1].equals("d")) {
                dis[i] = dis[i - 1] + U + D;
            } else {
                dis[i] = dis[i - 1] + 2 * F;
            }
        }
        int i = 0;
        for (i = T; i >= 0; i--) {
            if (dis[i] <= M) {
                break;
            }
        }
        System.out.println(i);
    }
}
