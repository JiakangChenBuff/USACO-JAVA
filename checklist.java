import java.util.*;
public class checklist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int G = sc.nextInt();
        int[][] hArr = new int[H + 1][2];
        for (int i = 1; i <= H; i++) {
            hArr[i][0] = sc.nextInt();
            hArr[i][1] = sc.nextInt();
        }
        int[][] gArr = new int[G + 1][2];
        for (int i = 1; i <= G; i++) {
            gArr[i][0] = sc.nextInt();
            gArr[i][1] = sc.nextInt();
        }
        int[][] dpH = new int[H + 1][G + 1];
        int[][] dpG = new int[H + 1][G + 1];
        for (int i = 1; i <= H; i++) {
            dpG[i][0] = Integer.MAX_VALUE / 2;
            if (i != 1) {
                dpH[i][0] = dpH[i - 1][0] + dis(i - 1, hArr, i, hArr);
            }
        }
        for (int i = 1; i <= G; i++) {
            dpH[0][i] = Integer.MAX_VALUE / 2;
            dpG[0][i] = Integer.MAX_VALUE / 2;
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= G; j++) {
                dpH[i][j] = Math.min(dpH[i - 1][j] + dis(i - 1, hArr, i, hArr), dpG[i - 1][j] + dis(j, gArr, i, hArr));
                dpG[i][j] = Math.min(dpH[i][j - 1] + dis(i, hArr, j, gArr), dpG[i][j - 1] + dis(j - 1, gArr, j, gArr));
            }
        }
        System.out.println(dpH[H][G]);
        sc.close();
    }

    public static int dis(int x, int[][] X, int y, int[][] Y) {
        return (int) Math.pow(X[x][0] - Y[y][0], 2) + (int) Math.pow(X[x][1] - Y[y][1], 2);
    }
}
