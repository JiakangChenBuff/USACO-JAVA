import java.util.*;
public class cowcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String W = sc.next();
        long N = sc.nextLong();
        ArrayList<Long> arr = new ArrayList<Long>();
        arr.add((long) W.length());
        while (arr.get(arr.size() - 1) * 2 <= (long) Math.pow(10, 18)) {
            arr.add(arr.get(arr.size() - 1) * 2);
        }
        int i = 0;
        while (N > arr.get(i)) {
            i++;
        }
        while (N > W.length()) {
            N = N - arr.get(i - 1) - 1;
            if (N == 0) {
                N += arr.get(i - 1);
            }
            i = 0;
            while (N > arr.get(i)) {
                i++;
            }
        }
        System.out.println(W.substring((int) N - 1, (int) N));
        sc.close();
    }
}
