import java.util.*;
public class reststops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int N = sc.nextInt();
        int rF = sc.nextInt();
        int rB = sc.nextInt();
        int[][] stops = new int[N][2];
        for (int i = 0; i < N; i++) {
            stops[i][0] = sc.nextInt();
            stops[i][1] = sc.nextInt();
        }
        Arrays.sort(stops, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        int prev = stops[0][0];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        arr.add(0);
        arr.add(stops[0][0]);
        arr.add(stops[0][1]);
        for (int i = 1; i < N; i++) {
            if (stops[i][0] > prev) {
                prev = stops[i][0];
                arr.add(stops[i][0]);
                arr.add(stops[i][1]);
            }
        }
        long count = 0;
        for (int i = 2; i < arr.size(); i += 2) {
            count += (long) (rF - rB) * (long) (arr.get(i) - arr.get(i - 2)) * (long) (arr.get(i + 1));
        }
        System.out.println(count);
        sc.close();
    }
}
