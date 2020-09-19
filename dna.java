import java.util.*;
public class dna {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int F = sc.nextInt();
        sc.nextLine();
        String[] bulls = new String[M];
        String[] cows = new String[F];
        for (int i = 0; i < M; i++) {
            bulls[i] = sc.nextLine();
        }
        for (int i = 0; i < F; i++) {
            cows[i] = sc.nextLine();
        }
        int[][] result = new int[M][F];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < F; c++) {
                result[r][c] = numOffspring(bulls, r, cows, c);
            }
        }
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < F; c++) {
                System.out.print(result[r][c] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static int numOffspring(String[] bulls, int r, String[] cows, int c) {
        int count = 0;
        String bull = bulls[r];
        String cow = cows[c];
        for (int i = 0; i < bulls.length; i++) {
            if (i != r) {
                int counter = 0;
                for (int j = 0; j < 25; j++) {
                    if (bulls[i].substring(j, j + 1).equals(bull.substring(j, j + 1)) || bulls[i].substring(j, j + 1).equals(cow.substring(j, j + 1))) {
                        counter++;
                    }
                }
                if (counter == 25) {
                    count++;
                }
            }
        }
        for (int i = 0; i < cows.length; i++) {
            if (i != c) {
                int counter = 0;
                for (int j = 0; j < 25; j++) {
                    if (cows[i].substring(j, j + 1).equals(bull.substring(j, j + 1)) || cows[i].substring(j, j + 1).equals(cow.substring(j, j + 1))) {
                        counter++;
                    }
                }
                if (counter == 25) {
                    count++;
                }
            }
        }
        return count;
    }
}
