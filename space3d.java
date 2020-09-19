import java.util.*;
public class space3d {
    public static void main(String[] args) {
        int[][] moves = new int[][] {
                {0, -1, 0},
                {0, 1, 0},
                {0, 0, -1},
                {0, 0, 1},
                {-1, 0, 0},
                {1, 0, 0},
        };
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        boolean[][][] isRock = new boolean[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String line = sc.nextLine();
                for (int k = 0; k < N; k++) {
                    isRock[i][j][k] = line.charAt(k) == '*';
                }
            }
        }
        boolean[][][] vis = new boolean[N][N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (isRock[i][j][k] && !vis[i][j][k]) {
                        count++;
                        Queue<Coordinate3D> Q = new LinkedList<>();
                        Q.add(new Coordinate3D(i, j, k));
                        vis[i][j][k] = true;
                        while (!Q.isEmpty()) {
                            Coordinate3D curr = Q.poll();
                            for (int m = 0; m < moves.length; m++) {
                                int newI = curr.i + moves[m][0];
                                int newJ = curr.j + moves[m][1];
                                int newK = curr.k + moves[m][2];
                                if (isValid(newI, newJ, newK, N) && !vis[newI][newJ][newK] && isRock[newI][newJ][newK]) {
                                    vis[newI][newJ][newK] = true;
                                    Q.add(new Coordinate3D(newI, newJ, newK));
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static boolean isValid(int i, int j, int k, int N) {
        return i >= 0 && i < N && j >= 0 && j < N && k >= 0 && k < N;
    }
}

class Coordinate3D {
    public int i;
    public int j;
    public int k;

    public Coordinate3D(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}
