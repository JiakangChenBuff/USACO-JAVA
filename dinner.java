import java.util.*;
public class dinner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] cX = new int[N];
        int[] cY = new int[N];
        for (int i = 0; i < N; i++) {
            cX[i] = sc.nextInt();
            cY[i] = sc.nextInt();
        }
        int[] sX = new int[M];
        int[] sY = new int[M];
        for (int i = 0; i < M; i++) {
            sX[i] = sc.nextInt();
            sY[i] = sc.nextInt();
        }
        boolean[] seated = new boolean[N];
        for (int i = 0; i < M; i++) {
            int minIndex = -1;
            long minDistance = Long.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (!seated[j]) {
                    long distance = (long) Math.pow((sX[i] - cX[j]), 2) + (long) Math.pow((sY[i] - cY[j]), 2);
                    if (distance < minDistance) {
                        minIndex = j;
                        minDistance = distance;
                    }
                }
            }
            seated[minIndex] = true;
        }
        boolean isHungry = false;
        for (int i = 0; i < N; i++) {
            if (!seated[i]) {
                System.out.println(i + 1);
                isHungry = true;
            }
        }
        if (!isHungry) {
            System.out.println(0);
        }
        sc.close();
    }
}
