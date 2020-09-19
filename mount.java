import java.util.*;
public class mount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = 1;
            int prev = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] <= prev) {
                    count++;
                    prev = heights[j];
                } else {
                    break;
                }
            }
            prev = heights[i];
            for (int j = i + 1; j < N; j++) {
                if (heights[j] <= prev) {
                    count++;
                    prev = heights[j];
                } else {
                    break;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
        sc.close();
    }
}
