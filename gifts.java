import java.util.*;
public class gifts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        Gift[] G = new Gift[N];
        for (int i = 0; i < N; i++) {
            int p = sc.nextInt();
            int s = sc.nextInt();
            G[i] = new Gift(p, s);
        }
        sc.close();
        Arrays.sort(G);
        int i = N - 1;
        for ( ; i >= 0; i--) {
            long sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += (G[j].price + G[j].ship);
            }
            Gift[] cpy = Arrays.copyOfRange(G, 0, i + 1);
            Arrays.sort(cpy, new comp3());
            sum -= cpy[i].price / 2;
            if (sum <= B) {
                break;
            }
        }
        System.out.println(i + 1);
    }
}

class Gift implements Comparable<Gift> {
    int price;
    int ship;

    public Gift(int p, int s) {
        price = p;
        ship = s;
    }

    public int compareTo(Gift other) {
        if (this.price + this.ship == other.price + other.ship) {
            return this.price - other.price;
        } else {
            return this.price + this.ship - other.price - other.ship;
        }
    }
}

class comp3 implements Comparator<Gift> {
    public int compare(Gift g1, Gift g2) {
        return g1.price - g2.price;
    }
}
