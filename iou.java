import java.util.*;
public class iou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
        }
        int balance = 0;
        int owed = 0;
        int dis = 0;
        int index = -1;
        for (int i = 0; i < N; i++) {
            int x = C[i];
            if (x > 0) {
                balance += x;
                dis++;
                if (owed > 0 && balance > owed) {
                    dis += 2 * (i - index);
                    index = -1;
                    balance -= owed;
                    owed = 0;
                }
            } else {
                if (balance + x >= 0) {
                    balance += x;
                    dis++;
                } else {
                    owed += -1 * x;
                    if (index == -1) {
                        index = i;
                    }
                    dis++;
                }
            }
        }
        System.out.println(dis);
        sc.close();
    }
}
