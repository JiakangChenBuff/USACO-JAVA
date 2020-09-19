import java.util.*;
public class lcs3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[] prev = new int[s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            int[] curr = new int[s2.length() + 1];
            for (int j = 1; j <= s2.length(); j++) {
                curr[j] = Math.max(Math.max(curr[j - 1], prev[j]), ((s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 : 0)) + prev[j - 1]);
            }
            prev = curr;
        }
        System.out.println(prev[s2.length()]);
        sc.close();
    }
}
