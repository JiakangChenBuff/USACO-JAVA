import java.util.*;
public class flow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] adj = new int[52][52];
        for (int i = 0; i < N; i++) {
            int A = map(sc.next());
            int B = map(sc.next());
            adj[A][B] += sc.nextInt();
            adj[B][A] = adj[A][B];
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < 52; i++) {
                if (i != 0 && i != 25) {
                    int first = -1;
                    int second = -1;
                    boolean third = false;
                    for (int j = 0; j < 52; j++) {
                        if (adj[i][j] != 0) {
                            if (first == -1) {
                                first = j;
                            } else if (second == -1) {
                                second = j;
                            } else {
                                third = true;
                                break;
                            }
                        }
                    }
                    if (third) {
                        continue;
                    }
                    if (second != -1) {
                        adj[first][second] += Math.min(adj[first][i], adj[i][second]);
                        adj[second][first] = adj[first][second];
                        adj[first][i] = 0;
                        adj[i][first] = 0;
                        adj[second][i] = 0;
                        adj[i][second] = 0;
                        changed = true;
                    } else if (first != -1) {
                        adj[i][first] = 0;
                        adj[first][i] = 0;
                        changed = true;
                    }
                }
            }
        }
        System.out.println(adj[0][25]);
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
