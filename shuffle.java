import java.util.*;
public class shuffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] shuffle = new int[N];
        int[] parentCount = new int[N];
        for (int i = 0; i < N; i++) {
            shuffle[i] = sc.nextInt() - 1;
            parentCount[shuffle[i]]++;
        }
        int result = N;
        Queue<Integer> Q = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            if (parentCount[i] == 0) {
                result--;
                Q.add(i);
            }
        }
        while (!Q.isEmpty()) {
            int curr = Q.poll();
            if (--parentCount[shuffle[curr]] == 0) {
                result--;
                Q.add(shuffle[curr]);
            }
        }
        System.out.println(result);
        sc.close();
    }
}
