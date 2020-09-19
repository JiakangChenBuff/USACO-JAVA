import java.util.*;
public class munch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        boolean[][] field = new boolean[R][C];
        int sR = 0;
        int sC = 0;
        for (int r = 0; r < R; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < C; c++) {
                field[r][c] = line.charAt(c) != '*';
                if (line.charAt(c) == 'C') {
                    sR = r;
                    sC = c;
                }
            }
        }
        int[][] dis = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                dis[r][c] = Integer.MAX_VALUE;
            }
        }
        dis[sR][sC] = 0;
        boolean[][] vis = new boolean[R][C];
        vis[sR][sC] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(sR);
        q.add(sC);
        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();
            if (r > 0 && field[r - 1][c] && !vis[r - 1][c]) {
                dis[r - 1][c] = Math.min(dis[r - 1][c], 1 + dis[r][c]);
                q.add(r - 1);
                q.add(c);
                vis[r - 1][c] = true;
            }
            if (r < R - 1 && field[r + 1][c] && !vis[r + 1][c]) {
                dis[r + 1][c] = Math.min(dis[r + 1][c], 1 + dis[r][c]);
                q.add(r + 1);
                q.add(c);
                vis[r + 1][c] = true;
            }
            if (c > 0 && field[r][c - 1] && !vis[r][c - 1]) {
                dis[r][c - 1] = Math.min(dis[r][c - 1], 1 + dis[r][c]);
                q.add(r);
                q.add(c - 1);
                vis[r][c - 1] = true;
            }
            if (c < C - 1 && field[r][c + 1] && !vis[r][c + 1]) {
                dis[r][c + 1] = Math.min(dis[r][c + 1], 1 + dis[r][c]);
                q.add(r);
                q.add(c + 1);
                vis[r][c + 1] = true;
            }
        }
        System.out.println(dis[0][0]);
        sc.close();
    }
}
