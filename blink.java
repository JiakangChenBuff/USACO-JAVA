import java.util.*;
public class blink {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long B = sc.nextLong();
        int[][] states = new int[(int) Math.pow(2, N) + 1][N];
        for (int i = 0; i < N; i++) {
            states[0][i] = sc.nextInt();
        }
        int[] timeSeen = new int[(int) Math.pow(2, N) + 1];
        for (int i = 0; i < timeSeen.length; i++) {
            timeSeen[i] = -1;
        }
        int T = 0;
        while (timeSeen[toNum(states[T])] == -1) {
            timeSeen[toNum(states[T])] = T;
            T++;
            update(states[T - 1], states[T]);
        }
        int x = timeSeen[toNum(states[T])];
        B -= x;
        B %= T - x;
        B += x;
        for (int i = 0; i < N; i++) {
            System.out.println(states[(int) B][i]);
        }
        sc.close();
    }

    public static void update(int[] prev, int[] curr) {
        for (int i = 0; i < prev.length; i++) {
            if (i == 0) {
                if (prev[prev.length - 1] == 1) {
                    curr[i] = prev[i] == 1 ? 0 : 1;
                } else {
                    curr[i] = prev[i];
                }
            } else {
                if (prev[i - 1] == 1) {
                    curr[i] = prev[i] == 1 ? 0 : 1;
                } else {
                    curr[i] = prev[i];
                }
            }
        }
    }

    public static int toNum(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i] * (int) (Math.pow(2, arr.length - 1 - i));
        }
        return count;
    }
}
