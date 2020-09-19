import java.util.*;
public class gravity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        boolean[][] isRock = new boolean[N][M];
        int[] pts = new int[4];
        for (int r = 0; r < N; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < M; c++) {
                if (line.charAt(c) == '#') {
                    isRock[r][c] = true;
                } else {
                    if (line.charAt(c) == 'C') {
                        pts[0] = r;
                        pts[1] = c;
                    } else if (line.charAt(c) == 'D') {
                        pts[2] = r;
                        pts[3] = c;
                    }
                }
            }
        }

        PriorityQueue<Position> Q = new PriorityQueue<Position>();
        Q.add(new Position(pts[0], pts[1], 1, 0));
        int[][] vis = new int[N][M];
        vis[pts[0]][pts[1]] = 1;
        boolean found = false;
        while (!Q.isEmpty()) {
            Position curr = Q.poll();
            if (curr.r == pts[2] && curr.c == pts[3]) {
                System.out.println(curr.v);
                found = true;
                break;
            }

            if (curr.r + curr.d < 0 || curr.r + curr.d >= N) {
                continue;
            }

            if (!isRock[curr.r + curr.d][curr.c]) {
                if (vis[curr.r + curr.d][curr.c] < 2) {
                    Q.add(new Position(curr.r + curr.d, curr.c, curr.d, curr.v));
                    vis[curr.r + curr.d][curr.c]++;
                }
            } else {
                if (curr.c - 1 >= 0 && vis[curr.r][curr.c - 1] < 2 && !isRock[curr.r][curr.c - 1]) {
                    Q.add(new Position(curr.r, curr.c - 1, curr.d, curr.v));
                    vis[curr.r][curr.c - 1]++;
                }

                if (curr.c + 1 < M && vis[curr.r][curr.c + 1] < 2 && !isRock[curr.r][curr.c + 1]) {
                    Q.add(new Position(curr.r, curr.c + 1, curr.d, curr.v));
                    vis[curr.r][curr.c + 1]++;
                }

                if (vis[curr.r][curr.c] < 2) {
                    Q.add(new Position(curr.r, curr.c, -curr.d, curr.v + 1));
                    vis[curr.r][curr.c]++;
                }
            }
        }
        if (!found) {
            System.out.println(-1);
        }
        sc.close();
    }
}

class Position implements Comparable<Position> {
    public int r;
    public int c;
    public int d;
    public int v;

    public Position(int R, int C, int D, int V) {
        r = R;
        c = C;
        d = D;
        v = V;
    }

    public int compareTo(Position other) {
        return this.v - other.v;
    }
}
