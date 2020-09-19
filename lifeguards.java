import java.util.*;
public class lifeguards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] intervals = new int[N][2];
        for (int i = 0; i < N; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[][] times = new int[2 * N][3];
        for (int i = 0; i < N; i++) {
            times[2 * i][0] = i;
            times[2 * i][1] = intervals[i][0];
            times[2 * i][2] = 0;
            times[2 * i + 1][0] = i;
            times[2 * i + 1][1] = intervals[i][1];
            times[2 * i + 1][2] = 1;
        }
        Arrays.sort(times, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();
        int[] timeAlone = new int[N];
        for (int i = 0; i < 2 * N; i++) {
            if (times[i][2] == 0) {
                if (Q.size() == 1) {
                    timeAlone[Q.peek()] += times[i][1] - times[i - 1][1];
                }
                Q.add(times[i][0]);
            } else {
                if (Q.size() == 1) {
                    timeAlone[times[i][0]] += times[i][1] - times[i - 1][1];
                }
                Q.poll();
            }
        }
        Arrays.sort(timeAlone);
        boolean wasCow = false;
        int total = 0;
        int cowCount= 0;
        for (int i = 0; i  < 2 * N; i++) {
            if (wasCow) {
                total += times[i][1] - times[i - 1][1];
            }
            if (times[i][2] == 0) {
                cowCount++;
            } else {
                cowCount--;
            }
            wasCow = cowCount != 0;
        }
        System.out.println(total - timeAlone[0]);
        sc.close();
    }
}
