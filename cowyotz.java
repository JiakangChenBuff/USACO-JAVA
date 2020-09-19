import java.util.*;
public class cowyotz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int E = sc.nextInt();
        sc.nextLine();
        int[][] expressions = new int[E][S];
        for (int i = 0; i < E; i++) {
            String line = sc.nextLine();
            String[] combinations = line.split("\\+");
            for (int j = 0; j < combinations.length; j++) {
                int first = Integer.parseInt(combinations[j].split("x")[0]);
                int second = Integer.parseInt(combinations[j].split("x")[1]);
                expressions[i][second - 1] = first;
            }
        }
        int count = 0;
        for (int i = 0; i < (int) Math.pow(S, N); i++) {
            int[] curr = new int[N];
            int tmp = i;
            int index = N - 1;
            while (tmp > 0) {
                curr[index] = tmp % S;
                tmp /= S;
                index--;
            }
            int[] currCount = new int[S];
            for (int j = 0; j < N; j++) {
                currCount[curr[j]]++;
            }
            boolean works = false;
            for (int j = 0; j < E; j++) {
                tmp = 0;
                for (int k = 0; k < S; k++) {
                    if (currCount[k] >= expressions[j][k]) {
                        tmp++;
                    }
                }
                if (tmp == S) {
                    works = true;
                    break;
                }
            }
            if (works) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
