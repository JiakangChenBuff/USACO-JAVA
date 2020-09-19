import java.util.*;
public class relayrace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        RelayCow[] C = new RelayCow[N];
        for (int i = 0; i < N; i++) {
            int L = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[M];
            for (int j = 0; j < M; j++) {
                A[j] = sc.nextInt() - 1;
            }
            C[i] = new RelayCow(L, M, A, i);
        }
        int[] endTimes = new int[N];
        boolean[] hasGone = new boolean[N];
        PriorityQueue<RelayCow> Q = new PriorityQueue<RelayCow>();
        C[0].setE(C[0].L);
        endTimes[C[0].I] = C[0].L;
        hasGone[C[0].I] = true;
        Q.add(C[0]);
        int T = 0;
        while (!Q.isEmpty()) {
            RelayCow curr = Q.poll();
            T = curr.E;
            for (int i = 0; i < curr.A.length; i++) {
                int y = curr.A[i];
                if (!hasGone[y]) {
                    RelayCow other = C[y];
                    other.setE(T + other.L);
                    Q.add(other);
                    hasGone[other.I] = true;
                    endTimes[other.I] = other.E;
                }
            }
        }
        Arrays.sort(endTimes);
        System.out.println(endTimes[N - 1]);
        sc.close();
    }
}

class RelayCow implements Comparable<RelayCow> {
    public int L;
    public int M;
    public int[] A;
    public int I;
    public int E = Integer.MAX_VALUE;

    public RelayCow(int l, int m, int[] a, int i) {
        L = l;
        M = m;
        A = a;
        I = i;
    }

    public void setE(int S) {
        E = S;
    }

    public int compareTo(RelayCow other) {
        return this.E - other.E;
    }
}