import java.util.*;
public class moosick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int C = sc.nextInt();
        int[] rSC = new int[C];
        for (int i = 0; i < C; i++) {
            rSC[i] = sc.nextInt();
        }
        Arrays.sort(rSC);
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < N - C + 1; i++) {
            int[] temp = Arrays.copyOfRange(arr, i, i + C);
            Arrays.sort(temp);
            int d = rSC[0] - temp[0];
            for (int j = 0; j < C; j++) {
                temp[j] += d;
            }
            boolean flag = true;
            for (int j = 0; j < C; j++) {
                if (temp[j] != rSC[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                ans.add(i + 1);
            }
        }
        System.out.println(count);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
        sc.close();
    }
}