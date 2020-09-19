import java.util.*;
public class greetings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int B = sc.nextInt();
        int E = sc.nextInt();
        int[] bWalk = new int[1000000];
        int[] eWalk = new int[1000000];
        int bIndex = 0;
        int eIndex = 0;
        for (int i = 0; i < B; i++) {
            int curr = sc.nextInt();
            String dir = sc.next();
            int num = 0;
            if (dir.equals("L")) {
                num = -1;
            } else {
                num = 1;
            }
            int j = 0;
            for (j = bIndex; j < curr + bIndex; j++) {
                bWalk[j] = num;
            }
            bIndex = j;
        }
        for (int i = 0; i < E; i++) {
            int curr = sc.nextInt();
            String dir = sc.next();
            int num = 0;
            if (dir.equals("L")) {
                num = -1;
            } else {
                num = 1;
            }
            int j = 0;
            for (j = eIndex; j < curr + eIndex; j++) {
                eWalk[j] = num;
            }
            eIndex = j;
        }
        int bPrev = 0;
        int ePrev = 0;
        int bCurr = 0;
        int eCurr = 0;
        int count = 0;
        for (int t = 0; t < 1000000; t++) {
            bCurr += bWalk[t];
            eCurr += eWalk[t];
            if (bPrev != ePrev && bCurr == eCurr) {
                count++;
            } else if (bPrev < ePrev && bCurr > eCurr) {
                count++;
            } else if (bPrev > ePrev && bCurr < eCurr) {
                count++;
            }
            bPrev = bCurr;
            ePrev = eCurr;
        }
        System.out.println(count);
        sc.close();
    }
}
