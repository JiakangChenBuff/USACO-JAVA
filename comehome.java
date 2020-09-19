import java.util.*;
public class comehome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int[][] adj = new int[52][52];
        for (int r = 0; r < 52; r++) {
            for (int c = 0; c < 52; c++) {
                adj[r][c] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < 52; i++) {
            adj[i][i] = 0;
        }
        for (int i = 0; i < P; i++) {
            int a = map(sc.next());
            int b = map(sc.next());
            int d = sc.nextInt();
            adj[a][b] = Math.min(adj[a][b], d);
            adj[b][a] = Math.min(adj[b][a], d);
        }

        for (int k = 0; k < 52; k++) {
            for (int i = 0; i < 52; i++) {
                if (adj[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 52; j++) {
                        if (adj[k][j] < Integer.MAX_VALUE) {
                            adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int minInd = 0;
        for (int i = 0; i < 25; i++) {
            if (adj[i][25] < min) {
                min = adj[i][25];
                minInd = i;
            }
        }
        System.out.println((char) (minInd + 65) + " " + min);
        sc.close();
    }

    public static int map(String str) {
        char letter = str.charAt(0);
        if (letter >= 65 && letter <= 90) {
            return letter - 65;
        } else {
            return letter - 71;
        }
    }
}
