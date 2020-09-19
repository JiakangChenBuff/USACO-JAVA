import java.util.*;
public class smount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        int[] width = new int[N];
        width[0] = 1;
        for (int i = 1; i < N; i++) {
            width[i] = (heights[i] >= heights[i - 1]) ? (width[i - 1] + 1) : 1;
        }
        int[] width2 = new int[N];
        width2[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            width2[i] += (heights[i] >= heights[i + 1]) ? (width2[i + 1] + 1) : 1;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, width[i] + width2[i] - 1);
        }
        System.out.println(max);
        sc.close();
    }
}
