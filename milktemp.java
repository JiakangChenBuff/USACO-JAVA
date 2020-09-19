import java.util.*;
public class milktemp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();
        int A = Y - X;
        int B = Y - Z;
        Integer[] times = new Integer[2 * N];
        for (int i = 0; i < 2 * N; i += 2) {
            times[i] = sc.nextInt();
            times[i + 1] = -1 * (sc.nextInt());
        }
        Arrays.sort(times, new comp1());
        int max = 0;
        int count = N * X;
        for (int i = 0; i < times.length; i++) {
            if (times[i] >= 0) {
                count += A;
            } else {
                count -= B;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
        sc.close();
    }
}

class comp1 implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        if (Math.abs(a) == Math.abs(b)) {
            return b - a;
        } else {
            return Math.abs(a) - Math.abs(b);
        }
    }
}

