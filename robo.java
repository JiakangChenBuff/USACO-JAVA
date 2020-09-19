import java.util.*;
public class robo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int counter = 1;
        Stack<Integer> S = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            if (sc.nextLine().equals("ADD")) {
                S.push(counter);
                counter++;
            } else {
                S.pop();
            }
        }
        System.out.println(S.size());
        Iterator<Integer> it = S.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        sc.close();
    }
}
