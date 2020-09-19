import java.util.*;
public class milkprod {
    public static int intervals[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        intervals = new int[M][3];
        for (int i = 0; i < M; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt() + R;
            intervals[i][2] = sc.nextInt();
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[M];
        dp[0] = intervals[0][2];
        for (int i = 1; i < M; i++) {
            int cap = binSearch(intervals[i][0]);
            if (cap == -1) {
                dp[i] = Math.max(dp[i - 1], intervals[i][2]);
            } else {
                dp[i] = Math.max(dp[i - 1], intervals[i][2] + dp[cap]);
            }
        }
        System.out.println(dp[M - 1]);
        sc.close();
    }

    public static int binSearch(int target) {
        int low = 0;
        int high = intervals.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (intervals[mid][1] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
