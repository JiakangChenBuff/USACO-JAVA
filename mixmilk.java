import java.util.*;
import java.io.*;
public class mixmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));

        int[] maxCap = new int[3];
        int[] currCap = new int[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            maxCap[i] = Integer.parseInt(st.nextToken());
            currCap[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 100; i++) {
            int currBucket = i % 3;
            int nextBucket = (i + 1) % 3;
            if (currCap[currBucket] + currCap[nextBucket] > maxCap[nextBucket]) {
                currCap[currBucket] -= (maxCap[nextBucket] - currCap[nextBucket]);
                currCap[nextBucket] = maxCap[nextBucket];
            } else {
                currCap[nextBucket] += currCap[currBucket];
                currCap[currBucket] = 0;
            }
        }
        out.println(currCap[0]);
        out.println(currCap[1]);
        out.println(currCap[2]);
        out.close();
        f.close();
    }
}
