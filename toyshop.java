import java.util.*;
public class toyshop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Toy[] arr = new Toy[N];
        for (int i = 0; i < arr.length; i++) {
            int j = sc.nextInt();
            int p = sc.nextInt();
            arr[i] = new Toy(i + 1, j, p);
        }
        Arrays.sort(arr);
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int totalCost = 0;
        for (int i = N - 1; i >= N - 3; i--) {
            indices.add(arr[i].index);
            totalCost += arr[i].price;
        }
        System.out.println(totalCost);
        for (int i = 0; i < indices.size(); i++) {
            System.out.println(indices.get(i));
        }
        sc.close();
    }
}

class Toy implements Comparable<Toy> {
    int index;
    int joy;
    int price;
    double metric;

    public Toy(int i, int j, int p) {
        index = i;
        joy = j;
        price = p;
        metric = ((double) j) / p;
    }

    public int compareTo(Toy other) {
        if (this.metric < other.metric) {
            return -1;
        } else if (this.metric > other.metric) {
            return 1;
        } else {
            return 0;
        }
    }
}