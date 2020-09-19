import java.util.*;
public class explore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        SignedInt[] arr = new SignedInt[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            arr[i] = new SignedInt(x);
        }
        Arrays.sort(arr, new comp());
        int loc = 0;
        int count = 0;
        long time = 0;
        for (int i = 0; i < N; i++) {
            int next = arr[i].signed;
            time += Math.abs(next - loc);
            loc = next;
            if (time < T) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}

class SignedInt {
    int unsigned;
    int signed;

    public SignedInt(int x) {
        signed = x;
        unsigned = Math.abs(x);
    }
}

class comp implements Comparator<SignedInt> {
    public int compare(SignedInt x1, SignedInt x2) {
        return x1.unsigned - x2.unsigned;
    }
}
