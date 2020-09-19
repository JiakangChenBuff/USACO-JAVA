import java.util.*;
public class cowrace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] bPos = new int[1000001];
        int T = 1;
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            for (int j = 0; j < t; j++) {
                bPos[T] = bPos[T - 1] + s;
                T++;
            }
        }
        T = 1;
        int[] ePos = new int[1000001];
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            for (int j = 0; j < t; j++) {
                ePos[T] = ePos[T - 1] + s;
                T++;
            }
        }
        boolean bWasFirst = false;
        boolean eWasFirst = false;
        int count = 0;
        for (int i = 1; i <= T; i++) {
            if (bPos[i] > ePos[i]) {
                if (!bWasFirst && eWasFirst) {
                    count++;
                }
                bWasFirst = true;
                eWasFirst = false;
            } else if (bPos[i] < ePos[i]){
                if (!eWasFirst && bWasFirst) {
                    count++;
                }
                bWasFirst = false;
                eWasFirst = true;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
