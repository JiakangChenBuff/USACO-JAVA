import java.util.*;
@SuppressWarnings({"unchecked", "rawtypes"})
public class shoppay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList[] arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        Queue<Integer> Q = new LinkedList<Integer>();
        while (sc.hasNextLine()) {
            String I = sc.next();
            int x = sc.nextInt();
            sc.nextLine();
            if (I.equals("C")) {
                Q.add(x);
            } else {
                arr[x - 1].add(Q.poll());
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i].size() + " ");
            for (int j = 0; j < arr[i].size(); j++) {
                System.out.print(arr[i].get(j) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
