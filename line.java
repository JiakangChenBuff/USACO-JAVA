import java.util.*;
public class line {
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            if (sc.next().equals("P")) {
                int[] res = pQuery(sc.nextLong() - 1);
                for (int num : res) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                int[] x = new int[N];
                for (int j = 0; j < N; j++) {
                    x[j] = sc.nextInt();
                }
                System.out.println(qQuery(x));
            }
        }
        sc.close();
    }

    public static int[] pQuery(long x) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            nums.add(i);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = nums.get((int) (x / factorial(N - i - 1)));
            nums.remove((int) (x / factorial(N - i - 1)));
            x %= factorial(N - i - 1);
        }
        return res;
    }

    public static long qQuery(int[] x) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            nums.add(i);
        }
        long res = 1;
        for (int i = 0; i < N; i++) {
            res += nums.indexOf(x[i]) * factorial(N - i - 1);
            nums.remove((Integer) x[i]);
        }
        return res;
    }

    public static long factorial(int x) {
        long res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }
}
