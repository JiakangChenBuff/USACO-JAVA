import java.util.*;
public class measurement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int G = sc.nextInt();
        int[][] logs = new int[N][3];
        for (int i = 0; i < N; i++) {
            logs[i][0] = sc.nextInt();
            logs[i][1] = sc.nextInt();
            logs[i][2] = sc.nextInt();
        }
        Arrays.sort(logs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int ans = 0;
        TreeMap<Integer, Integer> changed = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> counts = new TreeMap<Integer, Integer>();
        counts.put(G, 1000000000);
        for (int i = 0; i < N; i++) {
            int ref = changed.containsKey(logs[i][1]) ? changed.get(logs[i][1]) : G;

            boolean wasTop = ref == counts.lastKey();
            int wasCount = counts.get(ref);
            counts.put(ref, wasCount - 1);
            if (wasCount == 1) {
                counts.remove(ref);
            }

            ref += logs[i][2];
            int isCount = (counts.containsKey(ref) ? counts.get(ref) : 0) + 1;
            counts.put(ref, isCount);
            boolean isTop = ref == counts.lastKey();
            if (wasTop) {
                if (!isTop || wasCount != 1 || isCount != 1) {
                    ans++;
                }
            } else if (isTop) {
                ans++;
            }

            changed.put(logs[i][1], ref);
        }
        System.out.println(ans);
        sc.close();
    }
}
