import java.util.*;
public class horizon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        BuildEndPt[] endpts = new BuildEndPt[2 * N];
        for (int i = 0; i < 2 * N; i += 2) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Height h = new Height(sc.nextInt(), i);
            endpts[i] = new BuildEndPt(a, h);
            endpts[i + 1] = new BuildEndPt(-b, h);
        }
        Arrays.sort(endpts);

        long ans = 0;
        TreeSet<Height> activeHeights = new TreeSet<>();
        activeHeights.add(endpts[0].h);
        activeHeights.add(new Height(0, 2 * N));
        for (int i = 1; i < 2 * N; i++) {
            ans += ((long) Math.abs(endpts[i].x) - (long) Math.abs(endpts[i - 1].x)) * (long) activeHeights.iterator().next().h;
            if (endpts[i].x < 0) {
                activeHeights.remove(endpts[i].h);
            } else {
                activeHeights.add(endpts[i].h);
            }
        }
        System.out.println(ans);
        sc.close();
    }
}

class Height implements Comparable<Height> {
    public int h;
    public int i;

    public Height(int h, int i) {
        this.h = h;
        this.i = i;
    }

    public int compareTo(Height other) {
        if (other.h - this.h == 0) {
            return this.i - other.i;
        }
        return other.h - this.h;
    }
}

class BuildEndPt implements Comparable<BuildEndPt> {
    public int x;
    public Height h;

    public BuildEndPt(int x, Height h) {
        this.x = x;
        this.h = h;
    }

    public int compareTo(BuildEndPt other) {
        return Math.abs(x) - Math.abs(other.x);
    }
}