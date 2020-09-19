import java.util.*;
public class planting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] rect = new int[N][4];
        int[][] bp = new int[2 * N][3];
        for (int i = 0; i < N; i++) {
            rect[i][0] = sc.nextInt();
            rect[i][1] = sc.nextInt();
            rect[i][2] = sc.nextInt();
            rect[i][3] = sc.nextInt();
            bp[2 * i][0] = rect[i][0];
            bp[2 * i][1] = i;
            bp[2 * i][2] = 0;
            bp[2 * i + 1][0] = rect[i][2];
            bp[2 * i + 1][1] = i;
            bp[2 * i + 1][2] = 1;
        }
        Arrays.sort(bp, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int A = 0;
        boolean[] isActive = new boolean[N];
        for (int i = 0; i < 2 * N - 1; i++) {
            if (bp[i][2] == 0) {
                isActive[bp[i][1]] = true;
            } else {
                isActive[bp[i][1]] = false;
            }
            ArrayList<int[]> tmp = new ArrayList<int[]>();
            for (int j = 0; j < N; j++) {
                if (isActive[j]) {
                    tmp.add(new int[] { rect[j][3], 0 });
                    tmp.add(new int[] { rect[j][1], 1 });
                }
            }
            Collections.sort(tmp, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
            int total = 0;
            int numActive = 0;
            for (int j = 0; j < tmp.size() - 1; j++) {
                if (tmp.get(j)[1] == 0) {
                    numActive++;
                } else {
                    numActive--;
                }
                if (numActive > 0) {
                    total += (tmp.get(j + 1)[0] - tmp.get(j)[0]);
                }
            }
            A += total * (bp[i + 1][0] - bp[i][0]);
        }
        System.out.println(A);
        sc.close();
    }
}
