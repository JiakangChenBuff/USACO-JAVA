import java.util.*;
public class cline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int[] pos = new int[200001];
        int leftMost = 100000;
        int rightMost = 100001;
        int counter = 1;
        for (int i = 0; i < S; i++) {
            if (sc.next().equals("A")) {
                if (sc.next().equals("L")) {
                    pos[leftMost] = counter;
                    leftMost--;
                } else {
                    pos[rightMost] = counter;
                    rightMost++;
                }
                counter++;
            } else {
                if (sc.next().equals("L")) {
                    int num = sc.nextInt();
                    for (int j = leftMost + 1; j <= leftMost + num; j++) {
                        pos[j] = 0;
                    }
                    leftMost += num;
                    if (leftMost > rightMost) {
                        int temp = rightMost;
                        rightMost = leftMost;
                        leftMost = temp;
                    }
                } else {
                    int num = sc.nextInt();
                    for (int j = rightMost - 1; i >= rightMost - num; j--) {
                        pos[j] = 0;
                    }
                    rightMost -= num;
                    if (rightMost < leftMost) {
                        int temp = rightMost;
                        rightMost = leftMost;
                        leftMost = temp;
                    }
                }
            }
        }
        for (int po : pos) {
            if (po != 0) {
                System.out.println(po);
            }
        }
        sc.close();
    }
}
