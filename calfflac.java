import java.util.*;
public class calfflac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String P = "";
        while (sc.hasNextLine()) {
            P += sc.nextLine() + "\r\n";
        }
        ArrayList<Letter> L = new ArrayList<Letter>();
        for (int i = 0; i < P.length(); i++) {
            char c = P.charAt(i);
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                L.add(new Letter(Character.toString(c).toLowerCase(), i));
            }
        }
        int m = 0;
        int s = 0;
        int e = 0;
        for (int c = 0; c < L.size(); c++) {
            int l = c - 1;
            int r = c + 1;
            while (l >= 0 && r < L.size() && L.get(l).letter.equals(L.get(r).letter)) {
                l--;
                r++;
            }
            l++;
            r--;
            if (r - l + 1 > m) {
                m = r - l + 1;
                s = L.get(l).index;
                e = L.get(r).index;
            }
        }
        for (int c = 0; c < L.size() - 1; c++) {
            int m1 = c;
            int m2 = c + 1;
            int l = m1;
            int r = m2;
            while (l >= 0 && r < L.size() && L.get(l).letter.equals(L.get(r).letter)) {
                l--;
                r++;
            }
            l++;
            r--;
            if (r - l + 1 > m) {
                m = r - l + 1;
                s = L.get(l).index;
                e = L.get(r).index;
            }
        }
        System.out.println(m);
        System.out.println(P.substring(s, e + 1));
        sc.close();
    }
}

class Letter {
    public String letter;
    public int index;

    public Letter(String l, int i) {
        letter = l;
        index = i;
    }
}
