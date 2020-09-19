import java.util.*;
public class elect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] votes = new int[N][3];
        for (int i = 0; i < N; i++) {
            votes[i][0] = sc.nextInt();
            votes[i][1] = sc.nextInt();
            votes[i][2] = i;
        }
        Arrays.sort(votes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        votes = Arrays.copyOfRange(votes, 0, K);
        Arrays.sort(votes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        System.out.println(votes[0][2] + 1);
        sc.close();
    }
}
