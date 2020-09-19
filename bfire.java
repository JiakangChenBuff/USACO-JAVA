import java.util.*;
public class bfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] campFire = new int[N];
        for (int i = 0; i < N; i++) {
            campFire[i] = i;
        }
        int[] numMoved = new int[N];
        boolean[] isEmpty = new boolean[N];
        int currCow = 0;
        int currPos = 0;
        while (true) {
            isEmpty[currPos] = true;
            currPos = (currPos + currCow + 1) % N;
            if (isEmpty[currPos]) {
                break;
            }
            int temp = campFire[currPos];
            campFire[currPos] = currCow;
            numMoved[temp]++;
            if (numMoved[temp] > 1) {
                currCow = temp;
                break;
            }
            currCow = temp;
        }
        System.out.println(currCow + 1);
        sc.close();
    }
}
