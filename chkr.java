import java.util.*;
public class chkr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[][] board = new String[N][N];
        for (int r = 0; r < N; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < N; c++) {
                board[r][c] = line.substring(c, c + 1);
            }
        }
        boolean found = false;
        outer:
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c].equals("K")) {
                    ArrayList<Integer> mvs = new ArrayList<Integer>();
                    found = recurse(r, c, board, mvs);
                    if (found) {
                        for (int i = 0; i < mvs.size(); i += 2) {
                            System.out.println(mvs.get(i) + 1 + " " + (mvs.get(i + 1) + 1));
                        }
                        break outer;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("impossible");
        }
    }

    public static boolean recurse(int r, int c, String[][] board, ArrayList<Integer> mvs) {
        mvs.add(r); mvs.add(c);
        boolean isChecker = false;
        outer:
        for (String[] arr : board) {
            for (String s : arr) {
                if (s.equals("o")) {
                    isChecker = true;
                    break outer;
                }
            }
        }
        if (!isChecker) {
            return true;
        }
        int tmp = mvs.size();
        boolean f1, f2, f3, f4;
        f1 = f2 = f3 = f4 = false;

        if (r > 1 && c > 1 && board[r - 1][c - 1].equals("o")) {
            board[r - 1][c - 1] = "+";
            f1 = recurse(r - 2, c - 2, board, mvs);
            board[r - 1][c - 1] = "o";
        }
        if (!f1) {
            while (mvs.size() > tmp) {
                mvs.remove(mvs.size() - 1);
            }
        } else {
            return true;
        }

        if (r > 1 && c < board.length - 2 && board[r - 1][c + 1].equals("o")) {
            board[r - 1][c + 1] = "+";
            f2 = recurse(r - 2, c + 2, board, mvs);
            board[r - 1][c + 1] = "o";
        }
        if (!f2) {
            while (mvs.size() > tmp) {
                mvs.remove(mvs.size() - 1);
            }
        } else {
            return true;
        }

        if (r < board.length - 2 && c > 1 && board[r + 1][c - 1].equals("o")) {
            board[r + 1][c - 1] = "+";
            f3 = recurse(r + 2, c - 2, board, mvs);
            board[r + 1][c - 1] = "o";
        }
        if (!f3) {
            while (mvs.size() > tmp) {
                mvs.remove(mvs.size() - 1);
            }
        } else {
            return true;
        }

        if (r < board.length - 2 && c < board.length - 2 && board[r + 1][c + 1].equals("o")) {
            board[r + 1][c + 1] = "+";
            f4 = recurse(r + 2, c + 2, board, mvs);
            board[r + 1][c + 1] = "o";
        }
        if (!f4) {
            while (mvs.size() > tmp) {
                mvs.remove(mvs.size() - 1);
            }
        } else {
            return true;
        }

        return false;
    }
}
