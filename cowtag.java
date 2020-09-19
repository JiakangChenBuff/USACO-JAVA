import java.util.*;
public class cowtag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int[][] dis = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                dis[r][c] = (int) Math.pow(x[r] - x[c], 2) + (int) Math.pow(y[r] - y[c], 2);
            }
        }
        boolean tagged[] = new boolean[N];
        int j = 0;
        for (int i = N; i > 1;) {
            j %= N;
            if (!tagged[j]) {
                int minIndex = -1;
                for (int k = 0; k < N; k++) {
                    if (minIndex == -1 && k != j && !tagged[k]) {
                        minIndex = k;
                    }  if (k != j && !tagged[k] && dis[j][minIndex] > dis[j][k]) {
                        minIndex = k;
                    }
                }
                tagged[minIndex] = true;
                i--;
            }
            j++;
        }
        for (int i = 0; i < N; i++) {
            if (!tagged[i]) {
                System.out.println(i + 1);
                break;
            }
        }
        sc.close();
    }
}
