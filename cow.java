import java.util.*;
public class cow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int[] wCount = new int[N + 1];
        int[] oCount = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            wCount[i] = wCount[i + 1];
            oCount[i] = oCount[i + 1];
            if (str.charAt(i) == 'W') {
                wCount[i]++;
            } else if (str.charAt(i) == 'O') {
                oCount[i]++;
            }
        }
        int[] wCountPrefix = new int[oCount[0] + 1];
        int index = 1;
        for (int i = oCount.length - 1; i > 0; i--) {
            if (oCount[i] < oCount[i - 1]) {
                wCountPrefix[index] = wCountPrefix[index - 1] + wCount[i];
                index++;
            }
        }
        long count = 0;
        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'C') {
                count += wCountPrefix[oCount[i + 1]];
            }
        }
        System.out.println(count);
        sc.close();
    }
}
