import java.util.*;
@SuppressWarnings("unchecked")
public class picnic {
    public static int N;
    public static int[] numVis;
    public static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        N = sc.nextInt();
        int M = sc.nextInt();
        numVis = new int[N + 1];
        int[] starts = new int[K + 1];
        for (int i = 0; i < K; i++) {
            starts[i] = sc.nextInt();
            numVis[starts[i]]++;
        }
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj[A].add(B);
        }
        for (int i = 0; i < K; i++) {
            dfs(starts[i]);
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (numVis[i] == K) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static void dfs(int s) {
        boolean[] vis = new boolean[N + 1];
        vis[s] = true;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        while (!Q.isEmpty()) {
            int curr = Q.poll();
            for (Integer i : adj[curr]) {
                if (!vis[i]) {
                    numVis[i]++;
                    vis[i] = true;
                    Q.add(i);
                }
            }
        }
    }
}
