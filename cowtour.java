import java.util.*;
public class cowtour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] pts = new int[N][2];
        for (int i = 0; i < N; i++) {
            pts[i][0] = sc.nextInt();
            pts[i][1] = sc.nextInt();
        }

        double[][] adj = new double[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                adj[r][c] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < N; i++) {
            adj[i][i] = 0;
        }
        sc.nextLine();
        for (int r = 0; r < N; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < N; c++) {
                if (line.charAt(c) - 48 == 1) {
                    double dis = Math.sqrt(Math.pow(pts[r][0] - pts[c][0], 2) + Math.pow(pts[r][1] - pts[c][1], 2));
                    adj[r][c] = dis;
                    adj[c][r] = dis;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (adj[i][k] != Integer.MAX_VALUE) {
                    for (int j = 0; j < N; j++) {
                        if (adj[k][j] != Integer.MAX_VALUE) {
                            adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                        }
                    }
                }
            }
        }

        double[] max = new double[N];
        for (int i = 0; i < N; i++) {
            ArrayList<Double> dis = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (adj[i][j] != Integer.MAX_VALUE) {
                    dis.add(adj[i][j]);
                }
            }
            Collections.sort(dis);
            max[i] = dis.get(dis.size() - 1);
        }

        ArrayList<Integer> FA = new ArrayList<>();
        ArrayList<Integer> FB = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (adj[0][i] != Integer.MAX_VALUE) {
                FA.add(i);
            } else {
                FB.add(i);
            }
        }

        double dA = 0;
        double dB = 0;
        for (Integer i : FA) {
            dA = Math.max(dA, max[i]);
        }
        for (Integer i : FB) {
            dB = Math.max(dB, max[i]);
        }

        double diameter = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (adj[i][j] == Integer.MAX_VALUE) {
                    double disIJ = max[i] + max[j] + Math.sqrt(Math.pow(pts[i][0] - pts[j][0], 2) + Math.pow(pts[i][1] - pts[j][1], 2));
                    diameter = Math.min(diameter, Math.max(disIJ, Math.max(dA, dB)));
                }
            }
        }
        System.out.printf("%.6f %n", diameter);
        sc.close();
    }
}
