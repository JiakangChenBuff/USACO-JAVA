import java.util.*;
public class crazy {
    public static int[][] moves = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        Map<Integer, Integer> xM = new HashMap<>();
        Map<Integer, Integer> yM = new HashMap<>();
        int[] x = new int[2 * N + C];
        int[] y = new int[2 * N + C];
        int[][] fences = new int[N][4];
        int[][] cows = new int[C][2];
        for (int i = 0; i < N; i++) {
            fences[i][0] = sc.nextInt();
            fences[i][1] = sc.nextInt();
            fences[i][2] = sc.nextInt();
            fences[i][3] = sc.nextInt();
            if (fences[i][0] > fences[i][2]) {
                int temp = fences[i][0];
                fences[i][0] = fences[i][2];
                fences[i][2] = temp;
            }
            if (fences[i][1] > fences[i][3]) {
                int temp = fences[i][1];
                fences[i][1] = fences[i][3];
                fences[i][3] = temp;
            }
            x[2 * i] = fences[i][0];
            x[2 * i + 1] = fences[i][2];
            y[2 * i] = fences[i][1];
            y[2 * i + 1] = fences[i][3];
        }
        for (int i = 0; i < C; i++) {
            cows[i][0] = sc.nextInt();
            cows[i][1] = sc.nextInt();
            x[2 * N + i] = cows[i][0];
            y[2 * N + i] = cows[i][1];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int count = 1;
        for (int i = 0; i < 2 * N + C; i++) {
            xM.put(x[i], count);
            count++;
            while (i < 2 * N + C - 1 && x[i + 1] == x[i]) {
                i++;
            }
        }
        count = 1;
        for (int i = 0; i < 2 * N + C; i++) {
            yM.put(y[i], count);
            count++;
            while (i < 2 * N + C - 1 && y[i + 1] == y[i]) {
                i++;
            }
        }
        for (int i = 0; i < N; i++) {
            fences[i][0] = xM.get(fences[i][0]);
            fences[i][1] = yM.get(fences[i][1]);
            fences[i][2] = xM.get(fences[i][2]);
            fences[i][3] = yM.get(fences[i][3]);
        }
        for (int i = 0; i < C; i++) {
            cows[i][0] = xM.get(cows[i][0]);
            cows[i][1] = yM.get(cows[i][1]);
        }
        boolean[][][] A = new boolean[xM.size() + 2][yM.size() + 2][6];
        for (int i = 0; i < N; i++) {
            if (fences[i][0] != fences[i][2]) {
                for (int j = fences[i][0]; j < fences[i][2]; j++) {
                    A[j][fences[i][1] - 1][1] = true;
                    A[j][fences[i][1]][3] = true;
                }
            } else {
                for (int j = fences[i][1]; j < fences[i][3]; j++) {
                    A[fences[i][0] - 1][j][2] = true;
                    A[fences[i][0]][j][0] = true;
                }
            }
        }
        for (int i = 0; i < C; i++) {
            A[cows[i][0]][cows[i][1]][4] = true;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (!A[r][c][5]) {
                    int cowCount = 0;
                    Queue<int[]> Q = new LinkedList<>();
                    Q.add(new int[] {r, c});
                    A[r][c][5] = true;
                    while (!Q.isEmpty()) {
                        int[] curr = Q.poll();
                        int cR = curr[0];
                        int cC = curr[1];
                        if (A[cR][cC][4]) {
                            cowCount++;
                        }
                        for (int i = 0; i < 4; i++) {
                            int nR = cR + moves[i][0];
                            int nC = cC + moves[i][1];
                            if (isValid(nR, nC, A.length, A[0].length) && !A[cR][cC][i] && !A[nR][nC][5]) {
                                Q.add(new int[] {nR, nC});
                                A[nR][nC][5] = true;
                            }
                        }
                    }
                    result.add(cowCount);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        sc.close();
    }

    public static boolean isValid(int r, int c, int N, int M) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
