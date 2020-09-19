import java.util.*;
public class pathfind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt() - 1;
        int[][] adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                adj[i][j] = sc.nextInt();
            }
        }
        int[][] dis = new int[N][2];
        for (int i = 0; i < N; i++) {
            dis[i][0] = i + 1;
            dis[i][1] = -1;
        }
        dis[M][1] = 0;
        boolean[] vis = new boolean[N];
        vis[M] = true;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(M);
        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int i = 0; i < N; i++) {
                if (adj[x][i] == 1 && !vis[i]) {
                    vis[i] = true;
                    dis[i][1] = dis[x][1] + 1;
                    Q.add(i);
                }
            }
        }
        Arrays.sort(dis, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int i = 0;
        while (i < N && dis[i][1] == -1) {
            i++;
        }
        while (i < N) {
            int curr = dis[i][1];
            String res = dis[i][0] + " ";
            i++;
            while (i < N && dis[i][1] == curr) {
                res += dis[i][0] + " ";
                i++;
            }
            System.out.println(res);
        }
        sc.close();
    }
}
