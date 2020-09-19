import java.util.*;
public class bds {
    public static int N;
    public static int[] factorial = new int[] {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
    public static int count = 0;
    public static int[][] perms;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int S = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 1; i <= N; i++) {
            nums[i - 1] = i;
        }
        perms = new int[factorial[N]][N];
        recurse(N, nums);
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < perms.length; i++) {
            int curr = sum(perms[i]);
            if (curr == S) {
                if (isLess(perms[i], ans)) {
                    ans = perms[i];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        sc.close();
    }

    public static boolean isLess(int[] a, int[] b) {
        for (int i = 0; i < N; i++) {
            if (a[i] < b[i]) {
                return true;
            } else if (a[i] > b[i]) {
                return false;
            }
        }
        return false;
    }

    public static int sum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += ((factorial[N - 1]) / (factorial[i] * factorial[N - 1 - i]) * nums[i]);
        }
        return res;
    }

    public static void recurse(int n, int[] nums) {
        if (n == 1) {
            perms[count] = Arrays.copyOf(nums, N);
            count++;
        } else {
            for (int i = 0; i < n - 1; i++) {
                recurse(n - 1, nums);
                if (n % 2 == 0) {
                    swap(nums, i, n - 1);
                } else {
                    swap(nums, 0, n - 1);
                }
            }
            recurse(n - 1, nums);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
