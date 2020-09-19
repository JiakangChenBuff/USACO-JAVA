import java.util.*;
public class sgraze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] intervals = new int[N][2];
        for (int i = 0; i < N; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int cap = binSearch(intervals, intervals[i][0]);
            if (cap == -1) {
                dp[i] = Math.max(dp[i - 1], 1);
            } else {
                dp[i] = Math.max(dp[i - 1], 1 + dp[cap]);
            }
        }
        System.out.println(dp[N - 1]);
        sc.close();
    }

    public static int binSearch(int[][] intervals, int target) {
        int low = 0;
        int high = intervals.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (intervals[mid][1] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
