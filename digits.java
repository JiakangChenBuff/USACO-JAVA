import java.util.*;
public class digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String b2 = sc.nextLine();
        String b3 = sc.nextLine();
        for (int i = 0; i < b2.length(); i++) {
            for (int j = 0; j < b3.length(); j++) {
                int d2 = Integer.parseInt(b2.substring(i, i + 1));
                int d3 = Integer.parseInt(b3.substring(j, j + 1));

                int nd2 = (d2 + 1) % 2;
                int nd31 = (d3 + 1) % 3;
                int nd32 = (d3 + 2) % 3;

                int count2 = 0;
                int index = 0;
                for (int k = b2.length() - 1; k >= 0; k--) {
                    if (k == i) {
                        count2 += (nd2 * (int) Math.pow(2, index));
                    } else {
                        count2 += (Integer.parseInt(b2.substring(k, k + 1)) * (int) Math.pow(2, index));
                    }
                    index++;
                }
                int count31 = 0;
                int count32 = 0;
                index = 0;
                for (int k = b3.length() - 1; k >= 0; k--) {
                    if (k == j) {
                        count31 += (nd31 * (int) Math.pow(3, index));
                        count32 += (nd32 * (int) Math.pow(3, index));
                    } else {
                        int x = (Integer.parseInt(b3.substring(k, k + 1)) * (int) Math.pow(3, index));
                        count31 += x;
                        count32 += x;
                    }
                    index++;
                }
                if (count2 == count31 || count2 == count32) {
                    System.out.println(count2);
                    break;
                }
            }
        }
        sc.close();
    }
}
