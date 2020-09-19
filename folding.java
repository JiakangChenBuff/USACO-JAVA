import java.util.*;
public class folding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextInt();
        int[] knots = new int[N];
        for (int i = 0; i < N; i++) {
            knots[i] = sc.nextInt();
        }
        Arrays.sort(knots);
        int count = 0;
        for (int i = 1; i < N - 1; i++) {
            if (isValid(knots, knots[i])) {
                count++;
            }
        }
        for (int i = 0; i < N - 1; i++) {
            if (isValid(knots, (knots[i] + knots[i + 1]) / 2.0)) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static boolean isValid(int[] knots, double foldPt) {
        int numOnLeft = numOnLeft(knots, foldPt);
        if (numOnLeft > knots.length - numOnLeft) {
            int floorIndex = findFloorIndex(knots, foldPt - (knots[knots.length - 1] - foldPt));
            for (int i = floorIndex; i < knots.length; i++) {
                double target = foldPt - (knots[i] - foldPt);
                boolean reached = false;
                for (int j = 0; j < knots.length; j++) {
                    if (Double.compare(target, knots[j]) == 0) {
                        reached = true;
                    }
                }
                if (!reached) {
                    return false;
                }
            }
        } else {
            int ceilingIndex = findCeilingIndex(knots, foldPt + (foldPt - knots[0]));
            for (int i = 0; i < ceilingIndex; i++) {
                double target = foldPt + (foldPt - knots[i]);
                boolean reached = false;
                for (int j = 0; j < knots.length; j++) {
                    if (Double.compare(target, knots[j]) == 0) {
                        reached = true;
                    }
                }
                if (!reached) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int findFloorIndex(int[] knots, double floor) {
        int index = -1;
        for (int i = 0; i < knots.length; i++) {
            if (Double.compare(knots[i], floor) >= 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int findCeilingIndex(int[] knots, double ceiling) {
        int index = knots.length;
        for (int i = 0; i < knots.length; i++) {
            if (Double.compare(knots[i], ceiling) > 0) {
                index = i - 1;
                break;
            }
        }
        return index;
    }

    public static int numOnLeft(int[] knots, double foldPt) {
        int numLeft = 0;
        for (int i = 0; i < knots.length; i++) {
            if (knots[i] > foldPt) {
                break;
            } else {
                numLeft++;
            }
        }
        return numLeft;
    }
}
