import java.util.*;
import java.io.*;
public class cowroute {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowroute.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[][] adj = new long[1001][1001];
        int[][] flights = new int[1001][1001];
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                adj[i][j] = Long.MAX_VALUE;
                flights[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            long C = Long.parseLong(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            int[] cities = new int[count];
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < count; j++) {
                cities[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < count; j++) {
                for (int k = j + 1; k < count; k++) {
                    if (C < adj[cities[j]][cities[k]]) {
                        adj[cities[j]][cities[k]] = C;
                        flights[cities[j]][cities[k]] = k - j;
                    } else if (C == adj[cities[j]][cities[k]]) {
                        flights[cities[j]][cities[k]] = Math.min(flights[cities[j]][cities[k]], k - j);
                    }
                }
            }
        }

        long[] weights = new long[1001];
        int[] dis = new int[1001];
        for (int i = 1; i <= 1000; i++) {
            weights[i] = Long.MAX_VALUE;
            dis[i] = Integer.MAX_VALUE;
        }
        weights[A] = 0;
        dis[A] = 0;
        PriorityQueue<long[]> Q = new PriorityQueue<long[]>(new Comparator<long[]>() {
            public int compare(long[] a, long[] b) {
                if (a[1] - b[1] == 0) {
                    return Long.compare(a[2], b[2]);
                } else {
                    return Long.compare(a[1], b[1]);
                }
            }
        });
        Q.add(new long[] {A, 0, 0});
        boolean[] vis = new boolean[1001];
        while (!Q.isEmpty()) {
            long[] curr = Q.poll();
            int currV = (int) curr[0];
            if (vis[currV]) {
                continue;
            }
            vis[currV] = true;
            for (int i = 1; i <= 1000; i++) {
                if (adj[currV][i] < Long.MAX_VALUE && !vis[i]) {
                    if (weights[i] > weights[currV] + adj[currV][i]) {
                        weights[i] = weights[currV] + adj[currV][i];
                        dis[i] = dis[currV] + flights[currV][i];
                        Q.add(new long[] {i, weights[i], dis[i]});
                    } else if (weights[i] == weights[currV] + adj[currV][i] && dis[i] > dis[currV] + flights[currV][i]) {
                        dis[i] = dis[currV] + flights[currV][i];
                        Q.add(new long[] {i, weights[i], dis[i]});
                    }
                }
            }
        }

        if (weights[B] == Long.MAX_VALUE) {
            out.println("-1 -1");
        } else {
            out.println(weights[B] + " " + dis[B]);
        }
        out.close();
        f.close();
    }
}
