import java.util.*;
public class mootube {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q2 = sc.nextInt();
        ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<int[]>());
        }
        for (int i = 0; i < N - 1; i++) {
            int p = sc.nextInt() - 1;
            int q = sc.nextInt() - 1;
            int r = sc.nextInt();
            adj.get(p).add(new int[] {q, r});
            adj.get(q).add(new int[] {p, r});
        }
        for (int i = 0; i < Q2; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt() - 1;
            int count = 0;
            Queue<Integer> Q = new LinkedList<Integer>();
            Q.add(v);
            boolean[] vis = new boolean[N];
            vis[v] = true;
            while (!Q.isEmpty()) {
                int x = Q.poll();
                for (int j = 0; j < adj.get(x).size(); j++) {
                    int[] y = adj.get(x).get(j);
                    if (!vis[y[0]] && y[1] >= k) {
                        vis[y[0]] = true;
                        count++;
                        Q.add(y[0]);
                    }
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
