import java.util.*;
public class auto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        AutoWord[] words = new AutoWord[W];
        for (int i = 0; i < W; i++) {
            words[i] = new AutoWord(sc.nextLine(), i + 1);
        }
        Arrays.sort(words);
        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            String part = sc.next();
            int ind = binarySearch(part, words) + k - 1;
            if (ind >= W || !words[ind].word.substring(0, part.length()).equals(part)) {
                System.out.println(-1);
            } else {
                System.out.println(words[ind].index);
            }
        }
        sc.close();
    }

    public static int binarySearch(String part, AutoWord[] words) {
        int low = 0;
        int high = words.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (words[mid].word.compareTo(part) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

class AutoWord implements Comparable<AutoWord> {
    public String word;
    public int index;

    public AutoWord(String w, int i) {
        word = w;
        index = i;
    }

    public int compareTo(AutoWord other) {
        return word.compareTo(other.word);
    }
}