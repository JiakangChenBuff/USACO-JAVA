import java.util.*;
public class tlines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] pos = new int[N][3];
        for (int i = 0; i < N; i++) {
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
            pos[i][2] = i;
        }
        if (isPossible(pos)) {
            System.out.println(1);
        } else {
            for (int i = 0; i < N; i++) {
                int tmp = pos[i][0];
                pos[i][0] = pos[i][1];
                pos[i][1] = tmp;
            }
            if (isPossible(pos)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        sc.close();
    }

    public static boolean isPossible(int[][] pos) {
        HashMap<Integer, ArrayList<Integer>> M = new HashMap<Integer, ArrayList<Integer>>();
        int distinct = 0;
        for (int i = 0; i < pos.length; i++) {
            if (!M.containsKey(pos[i][0])) {
                distinct++;
                M.put(pos[i][0], new ArrayList<Integer>());
            }
            M.get(pos[i][0]).add(pos[i][1]);
        }
        if (distinct <= 3) {
            return true;
        }
        HashMap<Integer, Integer> M2 = new HashMap<Integer, Integer>();
        distinct = 0;
        for (int i = 0; i < pos.length; i++) {
            if (!M2.containsKey(pos[i][1])) {
                distinct++;
                M2.put(pos[i][1], 0);
            }
            M2.put(pos[i][1], M2.get(pos[i][1]) + 1);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> E : M.entrySet()) {
           int tmp = distinct;
           for (Integer num : E.getValue()) {
               if (M2.get(num) == 1) {
                   tmp--;
               }
           }
            if (tmp <= 2) {
                return true;
            }
        }
        return false;
    }
}
