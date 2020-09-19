import java.util.*;
@SuppressWarnings("unchecked")
public class slide {
    public static int V, E, K;
    public static long ans[][];
    public static boolean seen[][];
    public static ArrayList<int[]> adj[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();
        ans = new long[V][K + 1];
        adj = new ArrayList[V];
        seen = new boolean[V][K + 1];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int P = sc.nextInt() - 1;
            int Q = sc.nextInt() - 1;
            int F = sc.nextInt();
            adj[P].add(new int[] {Q, F});
        }
        System.out.println(solve(0, K));
        sc.close();
    }

    public static long solve(int i, int j) {
        if (i == V - 1) {
            return 0;
        }
        if (seen[i][j]) {
            return ans[i][j];
        }
        seen[i][j] = true;
        long count1 = 0;
        for (int[] child : adj[i]) {
            count1 = Math.max(count1, child[1] + solve(child[0], j));
        }
        long count2 = Long.MAX_VALUE;
        if (j != 0) {
            for (int[] child : adj[i]) {
                count2 = Math.min(count2, child[1] + solve(child[0], j - 1));
            }
        }
        ans[i][j] = Math.min(count1, count2);
        return ans[i][j];
    }
}
