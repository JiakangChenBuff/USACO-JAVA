import java.util.*;
public class lphone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[H][W];
        boolean[][] isOpen = new boolean[H][W];
        boolean[][] vis = new boolean[H][W];
        int[] cowCoord = new int[4];
        int cowIndex = 0;

        for (int r = 0; r < H; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < W; c++) {
                if (line.charAt(c) == '.') {
                    isOpen[r][c] = true;
                } else if (line.charAt(c) == 'C') {
                    isOpen[r][c] = true;
                    cowCoord[cowIndex] = r;
                    cowCoord[cowIndex + 1] = c;
                    cowIndex += 2;
                }
            }
        }

        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                grid[r][c] = Integer.MAX_VALUE;
            }
        }
        grid[cowCoord[0]][cowCoord[1]] = -1;

        vis[cowCoord[0]][cowCoord[1]] = true;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(cowCoord[0]);
        Q.add(cowCoord[1]);
        while (!Q.isEmpty()) {
            int R = Q.poll();
            int C = Q.poll();

            for (int c = C - 1; c >= 0; c--) {
                if (!isOpen[R][c]) {
                    break;
                } else if (!vis[R][c]) {
                    grid[R][c] = Math.min(grid[R][c], grid[R][C] + 1);
                    vis[R][c] = true;
                    Q.add(R);
                    Q.add(c);
                }
            }

            for (int c = C + 1; c < W; c++) {
                if (!isOpen[R][c]) {
                    break;
                } else if (!vis[R][c]) {
                    grid[R][c] = Math.min(grid[R][c], grid[R][C] + 1);
                    vis[R][c] = true;
                    Q.add(R);
                    Q.add(c);
                }
            }

            for (int r = R - 1; r >= 0; r--) {
                if (!isOpen[r][C]) {
                    break;
                } else if (!vis[r][C]) {
                    grid[r][C] = Math.min(grid[r][C], grid[R][C] + 1);
                    vis[r][C] = true;
                    Q.add(r);
                    Q.add(C);
                }
            }

            for (int r = R + 1; r < H; r++) {
                if (!isOpen[r][C]) {
                    break;
                } else if (!vis[r][C]) {
                    grid[r][C] = Math.min(grid[r][C], grid[R][C] + 1);
                    vis[r][C] = true;
                    Q.add(r);
                    Q.add(C);
                }
            }
        }

        System.out.println(grid[cowCoord[2]][cowCoord[3]]);
        sc.close();
    }
}
