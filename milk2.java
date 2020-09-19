import java.util.*;
public class milk2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] times = new Integer[2 * N];
        for (int i = 0; i < 2 * N; i += 2) {
            times[i] = sc.nextInt();
            times[i + 1] = -1 * sc.nextInt();
        }
        Arrays.sort(times, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (Math.abs(a) == Math.abs(b)) {
                    if (a < 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return Math.abs(a) - Math.abs(b);
                }
            }
        });
        int maxMilk = 0;
        int maxIdle = 0;
        int numFarmers = 0;
        int currMilk = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (times[i] < 0) {
                numFarmers--;
            } else {
                numFarmers++;
            }
            if (numFarmers > 0) {
                currMilk += Math.abs(times[i + 1]) - Math.abs(times[i]);
                maxMilk = Math.max(maxMilk, currMilk);
            } else {
                if (i != 2 * N - 1) {
                    maxIdle = Math.max(maxIdle, times[i + 1] - Math.abs(times[i]));
                    currMilk = 0;
                }
            }
        }
        System.out.println(maxMilk + " " + maxIdle);
        sc.close();
    }
}
