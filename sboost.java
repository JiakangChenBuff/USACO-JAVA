import java.util.*;
public class sboost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int M = sc.nextInt();
        int N = sc.nextInt();
        double cA = ((double) F) / M;
        CarPart[] C = new CarPart[N];
        for (int i = 0; i < N; i++) {
            int f = sc.nextInt();
            int m = sc.nextInt();
            C[i] = new CarPart(f, m, i);
        }
        Arrays.sort(C);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            if (Double.compare(cA, C[i].A) < 0) {
                F += C[i].F;
                M += C[i].M;
                arr.add(C[i].I);
                cA = ((double) F) / M;
            } else {
                break;
            }
        }
        Collections.sort(arr);
        if (arr.size() == 0) {
            System.out.println("NONE");
        } else {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }
        }
        sc.close();
    }
}

class CarPart implements Comparable<CarPart> {
    int F;
    int M;
    int I;
    double A;

    public CarPart(int f, int m, int i) {
        F = f;
        M = m;
        I = i + 1;
        A = ((double) F) / M;
    }

    public int compareTo(CarPart other) {
        if (Double.compare(other.A, this.A) == 0) {
            return this.M - other.M;
        } else {
            return Double.compare(other.A, this.A);
        }
    }
}
