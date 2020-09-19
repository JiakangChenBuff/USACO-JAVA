import java.util.*;
public class skidesign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 83; i++) {
            min = Math.min(min, minCost(heights, i));
        }
        System.out.println(min);
        sc.close();
    }

    public static int minCost(int[] heights, int a) {
        int cost = 0;
        int min = a;
        int max = min + 17;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] < min) {
                cost += (int) (Math.pow(min - heights[i], 2));
            } else if (heights[i] > max) {
                cost += (int) (Math.pow(heights[i] - max, 2));
            }
        }
        return cost;
    }
}
