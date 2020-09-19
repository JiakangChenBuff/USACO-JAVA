import java.util.*;
public class citystate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] codes = new String[N];
        for (int i = 0; i < N; i++) {
            String city = sc.next();
            String state = sc.next();
            sc.nextLine();
            codes[i] = city.substring(0, 2) + state;
        }
        Arrays.sort(codes);
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!codes[i].substring(2).equals(codes[i].substring(0, 2))) {
                int lastLess = lastLess(codes[i].substring(2) + codes[i].substring(0, 2), codes);
                int firstMore = firstMore(codes[i].substring(2) + codes[i].substring(0, 2), codes);
                count += firstMore - lastLess - 1;
            }
        }
        System.out.println(count / 2);
        sc.close();
    }

    public static int lastLess(String code, String[] codes) {
        int low = 0;
        int high = codes.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (codes[mid].compareTo(code) >= 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static int firstMore(String code, String[] codes) {
        int low = 0;
        int high = codes.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (codes[mid].compareTo(code) <= 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
