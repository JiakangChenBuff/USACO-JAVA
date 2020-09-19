import java.util.*;
public class sed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = Math.min(Math.min(1 + dp[i - 1][j], 1 + dp[i][j - 1]) , ((s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1) + dp[i - 1][j - 1]);
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
        sc.close();
    }
}
