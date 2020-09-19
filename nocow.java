import java.util.*;
@SuppressWarnings("unchecked")
public class nocow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt() - 1;
        sc.nextLine();
        String[] sentences = new String[N];
        for (int i = 0; i < N; i++) {
            sentences[i] = sc.nextLine();
        }
        int numAdj = 0;
        {
            String curr = sentences[0].substring(19);
            Scanner temp = new Scanner(curr);
            while (temp.hasNext()) {
                String t = temp.next();
                if (!t.equals("cow.")) {
                    numAdj++;
                }
            }
            temp.close();
        }
        TreeSet<String>[] adj = new TreeSet[numAdj];
        for (int i = 0; i < numAdj; i++) {
            adj[i] = new TreeSet<String>();
        }
        for (int i = 0; i < N; i++) {
            String sentence = sentences[i].substring(19);
            Scanner senScanner = new Scanner(sentence);
            for (int j = 0; j < numAdj; j++) {
                adj[j].add(senScanner.next());
            }
            senScanner.close();
        }
        int[] bValues = new int[numAdj];
        bValues[numAdj - 1] = 1;
        for (int i = numAdj - 2; i >= 0; i--) {
            bValues[i] = bValues[i + 1] * adj[i + 1].size();
        }
        int numLessK = 0;
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            String sentence = sentences[i].substring(19);
            Scanner senScanner = new Scanner(sentence);
            int t = 0;
            for (int j = 0; j < numAdj; j++) {
                String word = senScanner.next();
                int index = findWord(word, adj[j]);
                t += bValues[j] * index;
            }
            temp[i] = t;
            senScanner.close();
        }
        Arrays.sort(temp);
        int[] restricted;
        if (temp[0] != 0) {
            restricted = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                restricted[i] = temp[i - 1];
            }
        } else {
            restricted = temp;
        }
        int counter = 0;
        for (int i = 1; i < restricted.length; i++) {
            counter += restricted[i] - restricted[i - 1] - 1;
            numLessK++;
            if (counter > K) {
                break;
            }
        }
        if (restricted.length == N + 1 && numLessK != N) {
            numLessK--;
        }
        K += numLessK;
        int[] indices = new int[numAdj];
        int tempI = 0;
        while (K > 0) {
            indices[tempI] = K / bValues[tempI];
            K -= indices[tempI] * bValues[tempI];
            tempI++;
        }
        String result = "";
        for (int i = 0; i < numAdj; i++) {
            String word = "";
            int t = 0;
            for (String s : adj[i]) {
                if (t == indices[i]) {
                    word = s;
                    break;
                }
                t++;
            }
            result = result + word + " ";
        }
        System.out.println(result.substring(0, result.length() - 1));
        sc.close();
    }

    private static int findWord(String word, TreeSet<String> adj) {
        int index = 0;
        for (String s : adj) {
            if (s.equals(word)) {
                break;
            }
            index++;
        }
        return index;
    }
}
