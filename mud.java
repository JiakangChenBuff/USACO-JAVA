import java.util.*;
public class mud {
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt() + 500;
        int Y = sc.nextInt() + 500;
        int N = sc.nextInt();
        boolean[][] isMud = new boolean[1010][1010];
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt() + 500;
            int B = sc.nextInt() + 500;
            isMud[A][B] = true;
        }

        boolean[][] vis = new boolean[1010][1010];
        int[][] dis = new int[1010][1010];
        vis[500][500] = true;
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[] {500, 500});
        while (!Q.isEmpty()) {
            int[] curr = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if (nx >= 0 && nx < 1010 && ny >= 0 && ny < 1010 && !isMud[nx][ny] && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    dis[nx][ny] = dis[curr[0]][curr[1]] + 1;
                    Q.add(new int[] {nx, ny});
                }
            }
        }
        System.out.println(dis[X][Y]);
        sc.close();
    }
}
