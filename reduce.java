import java.util.*;
public class reduce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int[] xSort = Arrays.copyOfRange(x, 0, N);
        Arrays.sort(xSort);
        int[] ySort = Arrays.copyOfRange(y, 0, N);
        Arrays.sort(ySort);
        int[][] rectangles = new int[256][4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = N - 1; j >= N - 4; j--) {
                for (int k = 0; k < 4; k++) {
                    for (int l = N - 1; l >= N - 4; l--) {
                        rectangles[index][0] = xSort[i];
                        rectangles[index][1] = xSort[j];
                        rectangles[index][2] = ySort[k];
                        rectangles[index][3] = ySort[l];
                        index++;
                    }
                }
            }
        }
        int area = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (numCowsOut(x, y, rectangles[i]) <= 3) {
                area = Math.min(area, (rectangles[i][1] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][2]));
            }
        }
        System.out.println(area);
        sc.close();
    }

    public static int numCowsOut(int[] x, int[] y, int[] rect) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (!(x[i] >= rect[0] && x[i] <= rect[1] && y[i] >= rect[2] && y[i] <= rect[3])) {
                count++;
            }
        }
        return count;
    }
}
