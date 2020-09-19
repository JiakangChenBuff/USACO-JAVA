import java.util.*;
public class baseball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] pos = new int[N];
        for (int i = 0; i < N; i++) {
            pos[i] = sc.nextInt();
        }
        Arrays.sort(pos);
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int dist = pos[j] - pos[i];
                int low = j + 1;
                int high = N - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (pos[mid] - pos[j] < dist) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                int low2 = j + 1;
                int high2 = N - 1;
                while (low2 <= high2) {
                    int mid = (low2 + high2) / 2;
                    if (pos[mid] - pos[j] > 2 * dist) {
                        high2 = mid - 1;
                    } else {
                        low2 = mid + 1;
                    }
                }
                count += high2 - low + 1;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
