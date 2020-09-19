import java.util.*;
public class moocrypt {
    public static char[][] puzzle;
    public static char[] letters;
    public static int[][] moves = {{-1, -1, -2, -2},
                                   {-1, 0, -2, 0},
                                   {-1, 1, -2, 2},
                                   {0, -1, 0, -2},
                                   {0, 1, 0, 2},
                                   {1, -1, 2, -2},
                                   {1, 0, 2, 0},
                                   {1, 1, 2, 2}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        puzzle = new char[N][M];
        for (int r = 0; r < N; r++) {
            String line = sc.next();
            for (int c = 0; c < M; c++) {
                puzzle[r][c] = line.charAt(c);
            }
        }
        int max = 0;
        letters = new char[26];
        for (int i = 0; i < 26; i++) {
            letters[i] = (char) (i + 65);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j && i != 12 && j != 14) {
                    max = Math.max(max, count(i, j));
                }
            }
        }
        System.out.println(max);
        sc.close();
    }

    public static int count(int f, int s) {
        int res = 0;
        for (int r = 0; r < puzzle.length; r++) {
            for (int c = 0; c < puzzle[0].length; c++) {
                if (puzzle[r][c] == letters[f]) {
                    for (int i = 0; i < 8; i++) {
                        if (isValid(i, r, c) &&
                            puzzle[r + moves[i][0]][c + moves[i][1]] == letters[s] &&
                            puzzle[r + moves[i][2]][c + moves[i][3]] == letters[s]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static boolean isValid(int i, int r, int c) {
        return (r + moves[i][2] >= 0) && (r + moves[i][2] < puzzle.length) && (c + moves[i][3] >= 0) && (c + moves[i][3] < puzzle[0].length);
    }
}
