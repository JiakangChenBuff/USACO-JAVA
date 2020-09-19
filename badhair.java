import java.util.*;
public class badhair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        SortedSet<Integer> S = new TreeSet<Integer>();
        long count = 0;
        for (int i = 0; i < N; i++) {
            S.add(heights[i]);
            Iterator<Integer> it = S.iterator();
            while (it.next() < heights[i]) {
                it.remove();
            }
            count += S.size() - 1;
        }
        System.out.println(count);
        sc.close();
    }
}
