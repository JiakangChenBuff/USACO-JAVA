import java.util.*;
public class helpcross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int N = sc.nextInt();

        TreeMap<Integer, Integer> chickens = new TreeMap<Integer, Integer>();
        int[][] cows = new int[N][2];

        for (int i = 0; i < C; i++) {
            int chicken = sc.nextInt();
            if (chickens.containsKey(chicken)) {
                chickens.put(chicken, chickens.get(chicken) + 1);
            } else {
                chickens.put(chicken, 1);
            }
        }
        for (int i = 0; i < N; i++) {
            cows[i][0] = sc.nextInt();
            cows[i][1] = sc.nextInt();
        }
        Arrays.sort(cows, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int matches = 0;

        for (int i = 0; i < cows.length; i++) {
            Integer chicken = chickens.ceilingKey(cows[i][0]);
            if (chicken != null && chicken <= cows[i][1]) {
                matches++;
                chickens.put(chicken, chickens.get(chicken) - 1);
                if (chickens.get(chicken) == 0) {
                    chickens.remove(chicken);
                }
            }
        }

        System.out.println(matches);
        sc.close();
    }
}


