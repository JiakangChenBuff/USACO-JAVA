import java.util.*;
public class daisy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][] adj = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            adj[c1][c2] = true;
            adj[c2][c1] = true;
        }

        boolean[] vis = new boolean[N + 1];
        Queue<Integer> Q = new LinkedList<>();
        vis[1] = true;
        Q.add(1);
        while (!Q.isEmpty()) {
            int curr = Q.poll();
            for (int i = 1; i <= N; i++) {
                if (adj[curr][i] && !vis[i]) {
                    Q.add(i);
                    vis[i] = true;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!vis[i]) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(count);
        }
        sc.close();
    }
}
