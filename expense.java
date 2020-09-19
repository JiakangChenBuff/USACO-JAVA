import java.util.*;
public class expense {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
        }
        int low = 0;
        int high = 1000000000;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(money, mid, M)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
        sc.close();
    }

    public static boolean possible(int[] money, int target, int M) {
        int count = 1;
        int curr = 0;
        for (int i = 0; i < money.length; i++) {
            curr += money[i];
            if (curr > target) {
                count++;
                curr = money[i];
                if (curr > target) {
                    return false;
                }
            }
        }
        return count <= M;
    }
}
