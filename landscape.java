import java.util.*;
public class landscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = 0; j < a; j++) {
                arr1.add(i);
            }
            for (int j = 0; j < b; j++) {
                arr2.add(i);
            }
        }
        int[][] dp = new int[arr1.size() + 1][arr2.size() + 1];
        for (int i = 0; i <= arr1.size(); i++) {
            dp[i][0] = Y * i;
        }
        for (int i = 0; i <= arr2.size(); i++) {
            dp[0][i] = X * i;
        }
        for (int i = 1; i <= arr1.size(); i++) {
            for (int j = 1; j <= arr2.size(); j++) {
                dp[i][j] = Math.min(Math.min(X + dp[i][j - 1], Y + dp[i - 1][j]), Z * Math.abs(arr1.get(i - 1) - arr2.get(j - 1)) + dp[i - 1][j - 1]);
            }
        }
        System.out.println(dp[arr1.size()][arr2.size()]);
        sc.close();
    }
}
