import java.util.*;
public class castle {
    public static int[] dr = new int[] {0, -1, 0, 1};
    public static int[] dc = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] floor = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                floor[r][c] = sc.nextInt();
            }
        }

        Module[][] castle = new Module[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                castle[r][c] = new Module(r, c,false, -1, -1, map(floor[r][c]));
            }
        }

        int ind = 0;
        int maxCount = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!castle[r][c].vis) {
                    ind++;
                    int count = 1;
                    ArrayList<Module> arr = new ArrayList<>();
                    castle[r][c].vis = true;
                    castle[r][c].ind = ind;
                    Queue<Module> Q = new LinkedList<>();
                    Q.add(castle[r][c]);
                    arr.add(castle[r][c]);
                    while (!Q.isEmpty()) {
                        Module curr = Q.poll();

                        for (int i = 0; i < 4; i++) {
                            if (!curr.walls[i] && isValid(curr.r + dr[i], curr.c + dc[i], N, M) && !castle[curr.r + dr[i]][curr.c + dc[i]].vis) {
                                count++;
                                castle[curr.r + dr[i]][curr.c + dc[i]].vis = true;
                                castle[curr.r + dr[i]][curr.c + dc[i]].ind = ind;
                                arr.add(castle[curr.r + dr[i]][curr.c + dc[i]]);
                                Q.add(castle[curr.r + dr[i]][curr.c + dc[i]]);
                            }
                        }
                    }
                    for (int i = 0; i < arr.size(); i++) {
                        arr.get(i).val = count;
                    }
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        System.out.println(ind);
        System.out.println(maxCount);

        int maxComb = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int i = 0; i < 4; i++) {
                    if (isValid(r + dr[i], c + dc[i], N, M) && castle[r][c].ind != castle[r + dr[i]][c + dc[i]].ind) {
                        maxComb = Math.max(maxComb, castle[r][c].val + castle[r + dr[i]][c + dc[i]].val);
                    }
                }
            }
        }
        System.out.println(maxComb);
        sc.close();
    }

    public static boolean isValid(int r, int c, int N, int M) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    public static boolean[] map(int x) {
        switch(x) {
            case 0:
                return new boolean[] {false, false, false, false};
            case 1:
                return new boolean[] {true, false, false, false};
            case 2:
                return new boolean[] {false, true, false, false};
            case 3:
                return new boolean[] {true, true, false, false};
            case 4:
                return new boolean[] {false, false, true, false};
            case 5:
                return new boolean[] {true, false, true, false};
            case 6:
                return new boolean[] {false, true, true, false};
            case 7:
                return new boolean[] {true, true, true, false};
            case 8:
                return new boolean[] {false, false, false, true};
            case 9:
                return new boolean[] {true, false, false, true};
            case 10:
                return new boolean[] {false, true, false, true};
            case 11:
                return new boolean[] {true, true, false, true};
            case 12:
                return new boolean[] {false, false, true, true};
            case 13:
                return new boolean[] {true, false, true, true};
            case 14:
                return new boolean[] {false, true, true, true};
            default:
                return new boolean[] {true, true, true, true};
        }
    }
}

class Module {
    public int r;
    public int c;
    public boolean vis;
    public int ind;
    public int val;
    public boolean[] walls;

    public Module (int R, int C, boolean VIS, int IND, int VAL, boolean[] WALLS) {
        r = R;
        c = C;
        vis = VIS;
        ind = IND;
        val = VAL;
        walls = WALLS;
    }
}
