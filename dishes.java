import java.util.*;
@SuppressWarnings({"unchecked", "rawtypes"})
public class dishes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] base = new int[N + 1];
        ArrayList[] stacks = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            stacks[i] = new ArrayList<Integer>();
        }
        int ans = N;
        int removed = 0;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x < removed) {
                ans = i;
                break;
            }

            for (int j = x; j >= 1; j--) {
                if (base[j] != 0) {
                    break;
                } else {
                    base[j] = x;
                }
            }

            ArrayList<Integer> curr = (ArrayList<Integer>) stacks[base[x]];
            while (!curr.isEmpty() && curr.get(curr.size() - 1) < x) {
                removed = curr.remove(curr.size() - 1);
            }
            curr.add(x);
        }
        System.out.println(ans);
        sc.close();
    }
}
