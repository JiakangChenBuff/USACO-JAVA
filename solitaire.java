import java.util.*;
public class solitaire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                board[r][c] = map(sc.next().substring(0, 1));
            }
        }
        int max = 0;
        for (int i = 0; i < (int) Math.pow(2, 2 * N - 2); i++) {
            int[] path = generatePath(i, 2 * N - 2);
            if (isValid(path)) {
                int r = N - 1;
                int c = 0;
                int count = board[r][c];
                for (int j = 0; j < path.length; j++) {
                    if (path[j] == 0) {
                        r -= 1;
                        count += board[r][c];
                    } else {
                        c += 1;
                        count += board[r][c];
                    }
                }
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
        sc.close();
    }

    public static int map(String str) {
        switch (str) {
            case "A":
                return 1;
            case "T":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.parseInt(str);
        }
    }

    public static int[] generatePath(int num, int length) {
        int[] res = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            res[i] = num % 2;
            num /= 2;
        }
        return res;
    }

    public static boolean isValid(int[] path) {
        int count0 = 0;
        int count1 = 0;
        for (int value : path) {
            if (value == 0) {
                count0++;
            } else {
                count1++;
            }
        }
        return count0 == count1;
    }
}
