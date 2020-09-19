import java.util.*;
public class bronlily {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int M1 = sc.nextInt();
        int M2 = sc.nextInt();
        int[][] moves = {{-1 * M1, M2}, {-1 * M1, -1 * M2}, {-1 * M2, M1}, {-1 * M2, -1 * M1}, {M2, M1}, {M2, -1 * M1}, {M1, M2}, {M1, -1 * M2}};
        int[][] pond = new int[M][N];
        int sR = 0;
        int sC = 0;
        int eR = 0;
        int eC = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                pond[r][c] = sc.nextInt();
                if (pond[r][c] == 3) {
                    sR = r;
                    sC = c;
                } else if (pond[r][c] == 4) {
                    eR = r;
                    eC = c;
                }
            }
        }
        int[][] dis = new int[M][N];
        boolean[][] vis = new boolean[M][N];
        vis[sR][sC] = true;
        Queue<int[]> Q = new LinkedList<int[]>();
        Q.add(new int[] {sR, sC});
        while (!Q.isEmpty()) {
            int[] x = Q.poll();
            for (int i = 0; i < 8; i++) {
                int dX = x[0] + moves[i][0];
                int dY = x[1] + moves[i][1];
                if (dX >= 0 && dX < M && dY >= 0 && dY < N && !vis[dX][dY] && (pond[dX][dY] == 1 || pond[dX][dY] == 4)) {
                    vis[dX][dY] = true;
                    dis[dX][dY] = dis[x[0]][x[1]] + 1;
                    Q.add(new int[] {dX, dY});
                }
            }
        }
        System.out.println(dis[eR][eC]);
        sc.close();
    }
}
