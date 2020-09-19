import java.util.*;
public class paintjob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[] paints = new int[N];
        for (int i = 0; i < N; i++) {
            paints[i] = sc.nextInt();
        }
        boolean[] vis = new boolean[P + 1];
        vis[A] = true;
        int[] dis = new int[P + 1];
        for (int i = 0; i < P + 1; i++) {
            dis[i] = -1;
        }
        dis[A] = 0;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(A);
        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int i = 0; i < N; i++) {
                int dest = x * paints[i] % P;
                if (!vis[dest]) {
                    vis[dest] = true;
                    dis[dest] = dis[x] + 1;
                    Q.add(dest);
                }
            }
        }
        System.out.println(dis[B]);
        sc.close();
    }
}
