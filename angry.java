import java.util.*;
public class angry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] hay = new int[N];
        for (int i = 0; i < N; i++) {
            hay[i] = sc.nextInt();
        }
        Arrays.sort(hay);
        int low = 0;
        int high = hay[N - 1] / 2 + 1;
        while (low <= high) {
            int R = (low + high) / 2;
            if (cowsNeeded(hay, R) > K) {
                low = R + 1;
            } else {
                high = R - 1;
            }
        }
        System.out.println(low);
        sc.close();
    }

    public static int cowsNeeded(int[] hay, int R) {
        int count = 0;
        int index = 0;
        while (index < hay.length) {
            int curr = hay[index];
            int dest = curr + 2 * R;
            while (index < hay.length && hay[index] <= dest) {
                index++;
            }
            count++;
        }
        return count;
    }
}
