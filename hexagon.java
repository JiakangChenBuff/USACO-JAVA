import java.util.*;
public class hexagon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int H = sc.nextInt() - 1;
        int L = sc.nextInt();

        ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2 * K - 1; i++) {
            G.add(new ArrayList<Integer>());
        }
        int tmpCount = 0;
        for (int i = 0; i < 2 * K - 1; i++) {
            for (int j = 0; j < 2 * K - 1 - Math.abs(i - K + 1); j++) {
                G.get(i).add(tmpCount);
                tmpCount++;
            }
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 3 * K * (K - 1) + 1; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < 3 * K * (K - 1) + 1; i++) {
            int r;
            for (r = 1; r < 2 * K - 1; r++) {
                if (i < G.get(r).get(0)) {
                    break;
                }
            }
            r--;
            int c;
            for (c = 0; c < G.get(r).size(); c++) {
                if (G.get(r).get(c) == i) {
                    break;
                }
            }
            if (c != 0) {
                adj.get(i).add(G.get(r).get(c - 1));
            }
            if (c != G.get(r).size() - 1) {
                adj.get(i).add(G.get(r).get(c + 1));
            }
            if (r != 0) {
                if (G.get(r - 1).size() > G.get(r).size()) {
                    adj.get(i).add(G.get(r - 1).get(c));
                    adj.get(i).add(G.get(r - 1).get(c + 1));
                } else {
                    if (c == 0) {
                        adj.get(i).add(G.get(r - 1).get(c));
                    } else if (c == G.get(r).size() - 1){
                        adj.get(i).add(G.get(r - 1).get(c - 1));
                    } else {
                        adj.get(i).add(G.get(r - 1).get(c));
                        adj.get(i).add(G.get(r - 1).get(c - 1));
                    }
                }
            }
            if (r != 2 * K - 2) {
                if (G.get(r + 1).size() > G.get(r).size()) {
                    adj.get(i).add(G.get(r + 1).get(c));
                    adj.get(i).add(G.get(r + 1).get(c + 1));
                } else {
                    if (c == 0) {
                        adj.get(i).add(G.get(r + 1).get(c));
                    } else if (c == G.get(r).size() - 1){
                        adj.get(i).add(G.get(r + 1).get(c - 1));
                    } else {
                        adj.get(i).add(G.get(r + 1).get(c));
                        adj.get(i).add(G.get(r + 1).get(c - 1));
                    }
                }
            }
        }

        int[] dis = new int[3 * K * (K - 1) + 1];
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(H);
        boolean[] vis = new boolean[3 * K * (K - 1) + 1];
        vis[H] = true;
        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int i = 0; i < adj.get(x).size(); i++) {
                int y = adj.get(x).get(i);
                if (!vis[y]) {
                    vis[y] = true;
                    dis[y] = dis[x] + 1;
                    Q.add(y);
                }
            }
        }
        int count = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == L) {
                count++;
                res.append(i + 1).append("\n");
            }
        }
        System.out.println(count + "\n" + res.toString());
        sc.close();
    }
}
