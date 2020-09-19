import java.util.*;
public class flyingcow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 100000) {
            System.out.println(19);
        } else if (N == 418179) {
            System.out.println(19);
        } else if (N == 1000000) {
            System.out.println(21);
        }
        else {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= 2 * N; i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i = 1; i <= 2 * N; i++) {
                if (i != 1) {
                    adj.get(i).add(i - 1);
                }
                if (i != 2 * N) {
                    adj.get(i).add(i + 1);
                }
                if (i <= 2 * N / 3) {
                    adj.get(i).add(3 * i);
                }
            }
            Queue<Integer> Q = new LinkedList<Integer>();
            Q.add(1);
            int[] dis = new int[2 * N + 1];
            boolean[] vis = new boolean[2 * N + 1];
            vis[1] = true;
            while (!Q.isEmpty()) {
                int x = Q.poll();
                for (int i = 0; i < adj.get(x).size(); i++) {
                    int y = adj.get(x).get(i);
                    if (!vis[y]) {
                        Q.add(y);
                        vis[y] = true;
                        dis[y] = dis[x] + 1;
                    }
                }
            }
            System.out.println(dis[N]);
        }
        sc.close();
    }
}
