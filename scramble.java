import java.util.*;
public class scramble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] words = new String[2 * N][3];
        for (int i = 0; i < 2 * N; i++) {
            words[i][0] = "";
        }
        for (int i = 0; i < 2 * N; i += 2) {
            String word = sc.next();
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            for (int j = 0; j < wordArr.length; j++) {
                words[i][0] += wordArr[j];
                words[i + 1][0] += wordArr[wordArr.length - 1 - j];
            }
            words[i][1] = "1";
            words[i][2] = Integer.toString(i / 2);
            words[i + 1][1] = "2";
            words[i + 1][2] = words[i][2];
        }
        Arrays.sort(words, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                if (a[0].equals(b[0])) {
                    return a[1].compareTo(b[1]);
                } else {
                    return a[0].compareTo(b[0]);
                }
            }
        });
        int aCount = 0;
        int bCount = 0;
        int[][] res = new int[N][2];
        for (int i = 0; i < 2 * N; i++) {
            if (Integer.parseInt(words[i][1]) == 1) {
                aCount++;
                res[Integer.parseInt(words[i][2])][0] = bCount + 1;
            } else {
                bCount++;
                res[Integer.parseInt(words[i][2])][1] = aCount;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
        sc.close();
    }
}
