import java.util.*;
@SuppressWarnings({"unchecked", "rawtypes"})
public class ttime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        ArrayList[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        boolean[] vis = new boolean[N + 1];
        int[] comp = new int[N + 1];
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!vis[i]) {
                count++;
                vis[i] = true;
                comp[i] = count;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    ArrayList<Integer> neighbors = (ArrayList<Integer>) adj[curr];
                    for (Integer n : neighbors) {
                        if (!vis[n]) {
                            vis[n] = true;
                            comp[n] = count;
                            q.add(n);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < Q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (comp[a] == comp[b]) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
        sc.close();
    }
}
