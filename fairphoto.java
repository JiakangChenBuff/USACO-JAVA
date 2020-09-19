import java.util.*;
public class fairphoto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] pos = new String[N][2];
        for (int i = 0; i < N; i++) {
            pos[i][0] = sc.next();
            pos[i][1] = sc.next();
        }
        Arrays.sort(pos, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
            }
        });
        boolean[] seenSums = new boolean[2 * N + 1];
        int[] indexSeen = new int[2 * N + 1];
        int max = 0;
        seenSums[N] = true;
        indexSeen[N] = -1;
        int sum = N;
        for (int i = 0; i < N; i++) {
            if (pos[i][1].equals("G")) {
                sum++;
            } else {
                sum--;
            }
            if (seenSums[sum]) {
                int left = Integer.parseInt(pos[indexSeen[sum] + 1][0]);
                int right = Integer.parseInt(pos[i][0]);
                max = Math.max(max, right - left);
            } else {
                seenSums[sum] = true;
                indexSeen[sum] = i;
            }
        }
        for (int i = 0; i < N; i++) {
            int j = i + 1;
            while (j < N && pos[j][1].equals(pos[i][1])) {
                j++;
            }
            max = Math.max(max, Integer.parseInt(pos[j - 1][0]) - Integer.parseInt(pos[i][0]));
            i = j - 1;
        }
        System.out.println(max);
        sc.close();
    }
}
