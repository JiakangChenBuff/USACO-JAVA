import java.util.*;
@SuppressWarnings({"rawtypes", "unchecked"})
public class lightson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList[][] switches = new ArrayList[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                switches[r][c] = new ArrayList();
            }
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            switches[x][y].add(a);
            switches[x][y].add(b);
        }
        boolean[][] isOn = new boolean[N][N];
        isOn[0][0] = true;
        boolean[][] vis = new boolean[N][N];
        dfs(0, 0, switches, isOn, vis);
        int count = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (isOn[r][c]) {
                    count++;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static void dfs(int r, int c, ArrayList[][] switches, boolean[][] isOn, boolean[][] vis) {
        vis[r][c] = true;
        for (int i = 0; i < switches[r][c].size(); i += 2) {
            int x = (int) switches[r][c].get(i);
            int y = (int) switches[r][c].get(i + 1);
            if (!isOn[x][y]) {
                isOn[x][y] = true;
                boolean connected = false;

                if (x > 0 && isOn[x - 1][y] && vis[x - 1][y]) {
                    connected = true;
                }

                if (x < switches.length - 1 && isOn[x + 1][y] && vis[x + 1][y]) {
                    connected = true;
                }

                if (y > 0 && isOn[x][y - 1] && vis[x][y - 1]) {
                    connected = true;
                }

                if (y < switches.length - 1 && isOn[x][y + 1] && vis[x][y + 1]) {
                    connected = true;
                }

                if (connected) {
                    dfs(x, y, switches, isOn, vis);
                }
            }
        }

        if (r > 0 && isOn[r - 1][c] && !vis[r - 1][c]) {
            dfs(r - 1, c, switches, isOn, vis);
        }

        if (r < switches.length - 1 && isOn[r + 1][c] && !vis[r + 1][c]) {
            dfs(r + 1, c, switches, isOn, vis);
        }

        if (c > 0 && isOn[r][c - 1] && !vis[r][c - 1]) {
            dfs(r, c - 1, switches, isOn, vis);
        }

        if (c < switches.length - 1 && isOn[r][c + 1] && !vis[r][c + 1]) {
            dfs(r, c + 1, switches, isOn, vis);
        }
    }
}
