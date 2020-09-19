import java.util.*;
public class hay4sale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int H = sc.nextInt();
        int[] volumes = new int[H + 1];
        for (int i = 1; i <= H; i++) {
            volumes[i] = sc.nextInt();
        }
        int[] prev = new int[C + 1];
        for (int i = 1; i <= H; i++) {
            int[] curr = new int[C + 1];
            for (int j = 1; j <= C; j++) {
                if (j - volumes[i] >= 0) {
                    curr[j] = Math.max(prev[j], volumes[i] + prev[j - volumes[i]]);
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        System.out.println(prev[C]);
        sc.close();
    }
}
