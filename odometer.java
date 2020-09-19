import java.util.*;
public class odometer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        long Y = sc.nextLong();
        Set<Long> S = new HashSet<Long>();
        for (int len = 3; len < 17; len++) {
            for (int dig = 0; dig <= 9; dig++) {
                for (int difDig = 0; difDig <= 9; difDig++) {
                    if (difDig != dig && difDig != 0) {
                        for (int difPos = 0; difPos < len; difPos++) {
                            long curr = 0;
                            for (int pos = 0; pos < len; pos++) {
                                if (pos == difPos) {
                                    curr += difDig * (long) Math.pow(10, pos);
                                } else {
                                    curr += dig * (long) Math.pow(10, pos);
                                }
                            }
                            if (curr >= X && curr <= Y) {
                                S.add(curr);
                            }
                        }
                    } else if (difDig != dig){
                        for (int difPos = 0; difPos < len - 1; difPos++) {
                            long curr = 0;
                            for (int pos = 0; pos < len; pos++) {
                                if (pos == difPos) {
                                    curr += difDig * (long) Math.pow(10, pos);
                                } else {
                                    curr += dig * (long) Math.pow(10, pos);
                                }
                            }
                            if (curr >= X && curr <= Y) {
                                S.add(curr);
                            }
                        }
                    }
                }
            }
        }
        if (Y == (long) Math.pow(10, 16)) {
            S.add((long) Math.pow(10, 16));
        }
        System.out.println(S.size());
        sc.close();
    }
}
