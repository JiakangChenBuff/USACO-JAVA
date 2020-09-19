import java.util.*;
public class maze1 {
    public static int[] dr = {0, -1, 0, 1};
    public static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        sc.nextLine();

        char[][] maze = new char[2 * H + 1][2 * W + 1];
        for (int r = 0; r < 2 * H + 1; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < 2 * W + 1; c++) {
                maze[r][c] = line.charAt(c);
            }
        }

        Section[][] grid = new Section[H][W];
        for (int r = 1; r < 2 * H + 1; r += 2) {
            for (int c = 1; c < 2 * W + 1; c += 2) {
                boolean[] walls = new boolean[4];
                if (maze[r][c - 1] == '|') {
                    walls[0] = true;
                }
                if (maze[r - 1][c] == '-') {
                    walls[1] = true;
                }
                if (maze[r][c + 1] == '|') {
                    walls[2] = true;
                }
                if (maze[r + 1][c] == '-') {
                    walls[3] = true;
                }

                grid[(r - 1) / 2][(c - 1) / 2] = new Section((r - 1) / 2, (c - 1) / 2, false, walls, new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE});
            }
        }

        int[] start = new int[4];
        int sInd = 0;
        for (int r = 1; r < 2 * H + 1; r += 2) {
            if (maze[r][0] == ' ') {
                start[sInd] = (r - 1) / 2;
                start[sInd + 1] = 0;
                sInd += 2;
            }

            if (maze[r][2 * W] == ' ') {
                start[sInd] = (r - 1) / 2;
                start[sInd + 1] = W - 1;
                sInd += 2;
            }
        }
        for (int c = 1; c < 2 * W + 1; c += 2) {
            if (maze[0][c] == ' ') {
                start[sInd] = 0;
                start[sInd + 1] = (c - 1) / 2;
                sInd += 2;
            }

            if (maze[2 * H][c] == ' ') {
                start[sInd] = H - 1;
                start[sInd + 1] = (c - 1) / 2;
                sInd += 2;
            }
        }

        bfs(start[0], start[1], grid, 0);

        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                grid[r][c].vis = false;
            }
        }

        bfs(start[2], start[3], grid, 1);

        int ans = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                ans = Math.max(ans, Math.min(grid[r][c].val[0], grid[r][c].val[1]));
            }
        }
        System.out.println(ans);
        sc.close();
    }

    public static void bfs(int sr, int sc, Section[][] grid, int valInd) {
        Queue<Section> Q = new LinkedList<>();
        Q.add(grid[sr][sc]);
        grid[sr][sc].vis = true;
        grid[sr][sc].val[valInd] = 1;
        while (!Q.isEmpty()) {
            Section curr = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                if (isValid(nr, nc, grid.length, grid[0].length) && !curr.walls[i] && !grid[nr][nc].vis) {
                    grid[nr][nc].vis = true;
                    grid[nr][nc].val[valInd] = curr.val[valInd] + 1;
                    Q.add(grid[nr][nc]);
                }
            }
        }
    }

    public static boolean isValid(int r, int c, int H, int W) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }
}

class Section {
    public int r;
    public int c;
    public boolean vis;
    public boolean[] walls;
    public int[] val;

    public Section(int R, int C, boolean VIS, boolean[] W, int[] VAL) {
        r = R;
        c = C;
        vis = VIS;
        walls = W;
        val = VAL;
    }
}
