import java.util.*;
public class highcard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() * 2;
        boolean[] D = new boolean[N + 1];
        for (int i = 0; i < N / 2; i++) {
            D[sc.nextInt()] = true;
        }
        int[] E = new int[N / 2];
        int[] B = new int[N / 2];
        int eIndex = 0;
        int bIndex = 0;
        for (int i = 1; i < N + 1; i++) {
            if (D[i]) {
                E[eIndex] = i;
                eIndex++;
            } else {
                B[bIndex] = i;
                bIndex++;
            }
        }
        Arrays.sort(E);
        Arrays.sort(B);
        int counter = 0;
        int j = 0;
        for (int i = 0; i < N / 2; i++) {
            for ( ; j < N / 2; j++) {
                if (B[j] > E[i]) {
                    counter++;
                    j++;
                    break;
                }
            }
        }
        System.out.println(counter);
        sc.close();
    }
}
