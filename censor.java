import java.util.*;
public class censor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            res.append(S.charAt(i));
            if (res.length() >= T.length() && res.substring(res.length() - T.length(), res.length()).equals(T)) {
                res.delete(res.length() - T.length(), res.length());
            }
        }
        System.out.println(res.toString());
        sc.close();
    }
}
