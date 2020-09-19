import java.util.*;
import java.io.*;
public class feast {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[T + 1][2];
        dp[0][0] = true;
        dp[0][1] = true;
        for (int i = 1; i <= T; i++) {
            if (i - A >= 0) {
                dp[i][0] = dp[i][0] || dp[i - A][0];
            }
            if (i - B >= 0) {
                dp[i][0] = dp[i][0] || dp[i - B][0];
            }
        }
        for (int i = 1; i <= T; i++) {
            if (i - A >= 0) {
                dp[i][1] = dp[i][1] || dp[i - A][1];
            }
            if (i - B >= 0) {
                dp[i][1] = dp[i][1] || dp[i - B][1];
            }
            if (2 * i <= T) {
                dp[i][1] = dp[i][1] || dp[2 * i][0];
            }
            if (2 * i + 1 <= T) {
                dp[i][1] = dp[i][1] || dp[2 * i + 1][0];
            }
        }
        for (int i = T; i >= 0; i--) {
            if (dp[i][0] || dp[i][1]) {
                out.println(i);
                break;
            }
        }
        out.close();
        f.close();
    }
}
