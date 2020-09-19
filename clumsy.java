import java.util.*;
public class clumsy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = 0;
        int curr = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                curr++;
            } else {
                curr--;
                if (curr < 0) {
                    ans++;
                    curr += 2;
                }
            }
        }
        ans += curr / 2;
        System.out.println(ans);
        sc.close();
    }
}
