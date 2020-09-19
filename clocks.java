import java.util.*;
public class clocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] moves = new int[][] {
                {1, 1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 1, 1}
        };
        int[] clocks = new int[9];
        for (int i = 0; i < 9; i++) {
            clocks[i] = (sc.nextInt() / 3) % 4;
        }
        int[] result = new int[9];
        result[8] = 10000;
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                for (int c = 0; c < 4; c++) {
                    for (int d = 0; d < 4; d++) {
                        for (int e = 0; e < 4; e++) {
                            for (int f = 0; f < 4; f++) {
                                for (int g = 0; g < 4; g++) {
                                    for (int h = 0; h < 4; h++) {
                                        for (int i = 0; i < 4; i++) {
                                            int[] curr = add(clocks, moves[0], a);
                                            curr = add(curr, moves[1], b);
                                            curr = add(curr, moves[2], c);
                                            curr = add(curr, moves[3], d);
                                            curr = add(curr, moves[4], e);
                                            curr = add(curr, moves[5], f);
                                            curr = add(curr, moves[6], g);
                                            curr = add(curr, moves[7], h);
                                            curr = add(curr, moves[8], i);
                                            if (valid(curr)) {
                                                result = min(result, new int[] {a, b, c, d, e, f, g, h, i});
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < result[i]; j++) {
                ans.append((i + 1) + " ");
            }
        }
        ans.deleteCharAt(ans.length() - 1);
        System.out.println(ans.toString());
        sc.close();
    }

    public static boolean valid(int[] a) {
        int amount = 0;
        for (int i = 0; i < 9; i++) {
            amount += a[i];
        }
        return amount == 0;
    }

    public static int[] add(int[] a, int[] b, int amount) {
        int[] result = new int[9];
        for (int i = 0; i < 9; i++) {
            result[i] = (a[i] + amount * b[i]) % 4;
        }
        return result;
    }

    public static int[] min(int[] a, int[] b) {
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < 9; i++) {
            aCount += a[i];
            bCount += b[i];
        }
        if (aCount == bCount) {
            for (int i = 0; i < 9; i++) {
                if (a[i] > b[i]) {
                    return a;
                } else if (b[i] > a[i]) {
                    return b;
                }
            }
        } else {
            return (aCount > bCount) ? b : a;
        }
        return a;
    }
}
