import java.util.*;
public class cheat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int[] cards = new int[K];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < K; i++) {
            arr.add(i);
        }
        int index = 0;
        while (arr.size() > 0) {
            for (int i = 1; i <= N; i++) {
                cards[arr.get(index)] = i;
                arr.remove(index);
                if (arr.size() != 0) {
                    index = (index + P) % arr.size();
                }
            }
        }
        for (int i = 0; i < K; i++) {
            if (cards[i] == N) {
                System.out.println(i + 1);
            }
        }
        sc.close();
    }
}
