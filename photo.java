import java.util.*;
public class photo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] cowPair = new int[K][2];
        for (int i = 0; i < K; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a < b) {
                cowPair[i][0] = a;
                cowPair[i][1] = b;
            } else {
                cowPair[i][0] = b;
                cowPair[i][1] = a;
            }
        }
        Arrays.sort(cowPair, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int count = 1;
        int[] curr = {1, cowPair[0][1] - 1};
        for (int i = 1; i < K; i++) {
            if (cowPair[i][0] > curr[1]) {
                count++;
                curr = new int[]{curr[1], cowPair[i][1] - 1};
            }
        }
        if (curr[1] != N) {
            count++;
        }
        System.out.println(count);
        sc.close();
    }
}
