import java.util.*;
public class cornmaze {
    public static int N;
    public static int M;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        char[][] field = new char[N][M];
        int sR = 0;
        int sC = 0;
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int r = 0; r < N; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < M; c++) {
                field[r][c] = line.charAt(c);
                if (field[r][c] == '@') {
                    sR = r;
                    sC = c;
                } else if (field[r][c] >= 65 && field[r][c] <= 90) {
                    ArrayList<Integer> tmp = map.getOrDefault(field[r][c], new ArrayList<>());
                    tmp.add(r);
                    tmp.add(c);
                    map.put(field[r][c], tmp);
                }
            }
        }
        boolean[][] vis = new boolean[N][M];
        vis[sR][sC] = true;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sR);
        Q.add(sC);
        Q.add(0);
        while (!Q.isEmpty()) {
            int r = Q.poll();
            int c = Q.poll();
            int d = Q.poll();
            if (field[r][c] == '=') {
                System.out.println(d);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];
                if (isValid(nR, nC) && !vis[nR][nC] && (field[nR][nC] == '.' || field[nR][nC] == '=')) {
                    Q.add(nR);
                    Q.add(nC);
                    Q.add(d + 1);
                    vis[nR][nC] = true;
                } else if (isValid(nR, nC) && map.containsKey(field[nR][nC])) {
                    ArrayList<Integer> tmp = map.get(field[nR][nC]);
                    if (tmp.size() != 2) {
                        if (tmp.get(0) == nR && tmp.get(1) == nC) {
                            nR = tmp.get(2);
                            nC = tmp.get(3);
                        } else {
                            nR = tmp.get(0);
                            nC = tmp.get(1);
                        }
                    } else {
                        nR = tmp.get(0);
                        nC = tmp.get(1);
                    }
                    if (!vis[nR][nC]) {
                        Q.add(nR);
                        Q.add(nC);
                        Q.add(d + 1);
                        vis[nR][nC] = true;
                    }
                }
            }
        }
        sc.close();
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
