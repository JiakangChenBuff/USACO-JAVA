import java.util.*;
public class phrase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        String[] P = new String[M];
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            P[i] = sc.nextLine();
        }
        String[] R = new String[N];
        for (int i = 0; i < N; i++) {
            R[i] = sc.nextLine();
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            int length = R[i].length();
            for (int j = 0; j < M; j++) {
                if (P[j].length() >= length && P[j].substring(0, length).equals(R[i])) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
