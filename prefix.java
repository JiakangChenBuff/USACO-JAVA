import java.util.*;
public class prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> prefix = new ArrayList<>();
        String currPrefix = sc.next();
        while (!currPrefix.equals(".")) {
            prefix.add(currPrefix);
            currPrefix = sc.next();
        }
        StringBuilder S = new StringBuilder(200001);
        sc.nextLine();
        while (sc.hasNextLine()) {
            S.append(sc.nextLine());
        }
        String seq = S.toString();
        boolean[] dp = new boolean[seq.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= seq.length(); i++) {
            for (String pre : prefix) {
                if (pre.length() <= i && dp[i - pre.length()] && seq.substring(i - pre.length(), i).equals(pre)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        for (int i = seq.length(); i >= 0; i--) {
            if (dp[i]) {
                System.out.println(i);
                break;
            }
        }
        sc.close();
    }
}
