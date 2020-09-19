import java.util.*;
public class soda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[2 * N];
        for (int i = 0; i < 2 * N; i += 2) {
            arr[i] = sc.nextInt();
            arr[i + 1] = -1 * sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return (o2 - o1);
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });
        int curr = 0;
        int max = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (arr[i] > 0) {
                curr++;
            } else {
                curr--;
            }
            max = Math.max(max, curr);
        }
        System.out.println(max);
        sc.close();
    }
}
