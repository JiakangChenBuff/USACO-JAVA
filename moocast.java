import java.util.*;
public class moocast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] cows = new int[N][3];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int p = sc.nextInt();
            cows[i][0] = x;
            cows[i][1] = y;
            cows[i][2] = p;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j != i) {
                    if ((int) Math.pow(cows[i][2], 2) >= (int) Math.pow(cows[j][0] - cows[i][0], 2) + (int) Math.pow(cows[j][1] - cows[i][1], 2)) {
                        adj.get(i).add(j);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            boolean[] vis = new boolean[N];
            dfs(i, adj, vis);
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (vis[j]) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
        sc.close();
    }

    public static void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            int x = adj.get(curr).get(i);
            if (!vis[x]) {
                dfs(x, adj, vis);
            }
        }
    }
}
