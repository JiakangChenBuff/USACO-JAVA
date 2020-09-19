import java.util.*;
public class shelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        Arrays.sort(heights);
        int count = 0;
        int total = 0;
        int index = N - 1;
        while (total < B) {
            count++;
            total += heights[index];
            index--;
        }
        System.out.println(count);
        sc.close();
    }
}
