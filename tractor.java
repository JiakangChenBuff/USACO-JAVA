import java.util.*;
public class tractor {
    public static int[] dr = new int[] {0, -1, 0, 1};
    public static int[] dc = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean[][] isHay = new boolean[1005][1005];
        int[] start = new int[2];
        start[0] = sc.nextInt() + 2;
        start[1] = sc.nextInt() + 2;
        for (int i = 0; i < N; i++) {
            int r = sc.nextInt() + 2;
            int c = sc.nextInt() + 2;
            isHay[r][c] = true;
        }

        int[][] cost = new int[1005][1005];
        for (int r = 0; r < 1005; r++) {
            for (int c = 0; c < 1005; c++) {
                cost[r][c] = Integer.MAX_VALUE;
            }
        }
        cost[start[0]][start[1]] = 0;
        PriorityQueue<Coord> Q = new PriorityQueue<Coord>();
        Q.add(new Coord(start[0], start[1], 0));
        boolean[][] vis = new boolean[1005][1005];
        vis[start[0]][start[1]] = true;
        while (!Q.isEmpty()) {
            Coord curr = Q.poll();
            int R = curr.r;
            int C = curr.c;

            for (int i = 0; i < 4; i++) {
                if (R + dr[i] >= 0 && R + dr[i] < 1005 && C + dc[i] >= 0 && C + dc[i] < 1005 && !vis[R + dr[i]][C + dc[i]]) {
                    vis[R + dr[i]][C + dc[i]] = true;
                    if (isHay[R + dr[i]][C + dc[i]]) {
                        cost[R + dr[i]][C + dc[i]] = Math.min(cost[R + dr[i]][C + dc[i]], curr.v + 1);
                        Q.add(new Coord(R + dr[i], C + dc[i], curr.v + 1));
                    } else {
                        cost[R + dr[i]][C + dc[i]] = Math.min(cost[R + dr[i]][C + dc[i]], curr.v);
                        Q.add(new Coord(R + dr[i], C + dc[i], curr.v));
                    }
                }
            }
        }
        System.out.println(cost[2][2]);
        sc.close();
    }
}

class Coord implements Comparable<Coord> {
    public int r;
    public int c;
    public int v;

    public Coord(int R, int C, int V) {
        r = R;
        c = C;
        v = V;
    }

    public int compareTo(Coord other) {
        return this.v - other.v;
    }
}