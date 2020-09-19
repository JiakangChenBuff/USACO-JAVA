import java.util.*;
public class namenum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long num = sc.nextLong();
        sc.nextLine();
        String[] temp = new String[Long.toString(num).length()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = map(Integer.parseInt(Long.toString(num).substring(i, i + 1)));
        }
        ArrayList<String> names = new ArrayList<String>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            boolean same = true;
            if (temp.length == line.length()) {
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].indexOf(line.charAt(i)) == -1) {
                        same = false;
                        break;
                    }
                }
            } else {
                same = false;
            }

            if (same) {
                names.add(line);
            }
        }

        if (names.size() == 0) {
            System.out.println("NONE");
        } else {
            for (String str : names) {
                System.out.println(str);
            }
        }
        sc.close();
    }

    public static String map(int num) {
        switch (num) {
            case 2:
                return "ABC";
            case 3:
                return "DEF";
            case 4:
                return "GHI";
            case 5:
                return "JKL";
            case 6:
                return "MNO";
            case 7:
                return "PRS";
            case 8:
                return "TUV";
            default:
                return "WXY";
        }
    }
}
