import java.util.*;
public class coaster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        int L = sc.nextInt();
        int N = sc.nextInt();
        int B = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int X = sc.nextInt();
            int E = X + sc.nextInt();
            int F = sc.nextInt();
            int C = sc.nextInt();
            ArrayList<int[]> arr = map.getOrDefault(E, new ArrayList<>());
            arr.add(new int[] {X, F, C});
            map.put(E, arr);
        }
        int[][] dp = new int[L + 1][B + 1];
        for (int i = 1; i <= L; i++) {
            dp[i][0] = -1;
        }
        for (int i = 1; i <= L; i++) {
            ArrayList<int[]> tracks = map.getOrDefault(i, null);
            for (int j = 1; j <= B; j++) {
                dp[i][j] = -1;
            }
            if (tracks != null) {
                for (int j = 1; j <= B; j++) {
                    for (int[] track : tracks) {
                        if (j - track[2] >= 0 && dp[track[0]][j - track[2]] != -1) {
                            dp[i][j] = Math.max(dp[i][j], track[1] + dp[track[0]][j - track[2]]);
                        }
                    }
                }
            }
        }
        System.out.println(dp[L][B]);
        sc.close();
    }
}
