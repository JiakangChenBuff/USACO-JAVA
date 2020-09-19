import java.util.*;
public class unlock {
    static boolean[][][] grid = new boolean[3][10][10];
    static int[] minX = new int[3];
    static int[] minY = new int[3];
    static int[] maxX = new int[3];
    static int[] maxY = new int[3];

    static int[][] dif =new int[][] {
            {-1, 0, 0, 0},
            {1, 0, 0, 0},
            {0, -1, 0, 0},
            {0, 1, 0, 0},
            {0, 0, -1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, -1},
            {0, 0, 0, 1},
            {-1, 0, -1, 0},
            {1, 0, 1, 0},
            {0, -1, 0, -1},
            {0, 1, 0, 1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] N = new int[3];
        N[0] = sc.nextInt();
        N[1] = sc.nextInt();
        N[2] = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            int xMin = 10;
            int yMin = 10;
            int xMax = 0;
            int yMax = 0;
            for (int j = 0; j < N[i]; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                grid[i][x][y] = true;
                xMin = Math.min(xMin, x);
                yMin = Math.min(yMin, y);
                xMax = Math.max(xMax, x);
                yMax = Math.max(yMax, y);
            }
            minX[i] = xMin;
            minY[i] = yMin;
            maxX[i] = xMax;
            maxY[i] = yMax;
        }
        sc.close();
        Queue<State> q = new LinkedList<>();
        Set<State> vis = new HashSet<>();
        q.add(new State(0, 0, 0, 0, 0));
        while (!q.isEmpty()) {
            State state = q.poll();
            if (!intersect(0, 1, state) && !intersect(0, 2, state) && !intersect(1, 2, state)) {
                System.out.println(state.d);
                return;
            }

            for (int i = 0; i < 12; i++) {
                int nx1 = state.state[2] + dif[i][0];
                int ny1 = state.state[3] + dif[i][1];
                int nx2 = state.state[4] + dif[i][2];
                int ny2 = state.state[5] + dif[i][3];
                State newState = new State(nx1, ny1, nx2, ny2, state.d + 1);
                if (!vis.contains(newState) && check(newState)) {
                    q.add(newState);
                    vis.add(newState);
                }
            }
        }
        System.out.println(-1);
    }

    public static boolean intersect(int i, int j, State state) {
        return !(minX[i] + state.state[2 * i] > maxX[j] + state.state[2 * j] ||
                 maxX[i] + state.state[2 * i] < minX[j] + state.state[2 * j] ||
                 minY[i] + state.state[2 * i + 1] > maxY[j] + state.state[2 * j + 1] ||
                 maxY[i] + state.state[2 * i + 1] < minY[j] + state.state[2 * j + 1]);
    }

    public static boolean check(State state) {
        if (Math.abs(state.state[2]) > 10 || Math.abs(state.state[4]) > 10 || Math.abs(state.state[3]) > 10 || Math.abs(state.state[5]) > 10) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                for (int x = 0; x < 10; x++) {
                    for (int y = 0; y < 10; y++) {
                        if (grid[i][x][y]) {
                            int nx = x + state.state[2 * i] - state.state[2 * j];
                            int ny = y + state.state[2 * i + 1] - state.state[2 * j + 1];
                            if (isValid(nx, ny) && grid[j][nx][ny]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValid(int x, int y) {
        return (x >= 0 && x < 10 && y >= 0 && y < 10);
    }
}

class State {
    int[] state;
    int d;

    public State(int x1, int y1, int x2, int y2, int d) {
        state = new int[] {0, 0, x1, y1, x2, y2};
        this.d = d;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof State)) {
            return false;
        }

        State other = (State) o;

        return other.state[4] == this.state[4] && other.state[5] == this.state[5] && other.state[2] == this.state[2] && other.state[3] == this.state[3];
    }

    public int hashCode() {
        return Arrays.hashCode(state);
    }
}
