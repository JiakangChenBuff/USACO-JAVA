import java.util.*;
public class typo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = 0;
        int depth = 0;
        int closingSeen = 0;
        int openingSeen =0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                depth++;
                openingSeen++;
            } else {
                depth--;
                closingSeen++;
            }

            if (depth <= 1) {
                openingSeen = 0;
            }
            if (depth == -1) {
                ans = closingSeen;
                break;
            }
        }

        if (depth > 0) {
            ans = openingSeen;
        }

        System.out.println(ans);
        sc.close();
    }
}
