import java.util.*;
public class sandcas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int[] curr = new int[N];
        int[] target = new int[N];
        for (int i = 0; i < N; i++) {
            curr[i] = sc.nextInt();
            target[i] = sc.nextInt();
        }
        Arrays.sort(curr);
        Arrays.sort(target);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (curr[i] > target[i]) {
                ans += Y * (curr[i] - target[i]);
            } else {
                ans += X * (target[i] - curr[i]);
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
