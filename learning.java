import java.util.*;
public class learning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        Integer[] weights = new Integer[N];
        for (int i = 0; i < N; i++) {
            if (sc.next().equals("S")) {
                weights[i] = sc.nextInt();
            } else {
                weights[i] = -1 * sc.nextInt();
            }
        }
        Arrays.sort(weights, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        int sum = 0;
        if (weights[0] > 0 && weights[0] > A) {
            sum += weights[0] - A;
        }
        if (weights[N - 1] > 0 && weights[N - 1] < B) {
            sum += B - weights[N - 1] + 1;
        }
        for (int i = 0; i < N - 1; i++) {
            if (Math.abs(weights[i]) >= A && Math.abs(weights[i + 1]) < B) {
                if (weights[i] > 0 && weights[i + 1] > 0) {
                    sum += weights[i + 1] - weights[i];
                } else if (weights[i] > 0 && weights[i + 1] < 0) {
                    int midW = (Math.abs(weights[i + 1]) + weights[i]) / 2;
                    sum += midW - weights[i] + 1;
                } else if (weights[i] < 0 && weights[i + 1] > 0) {
                    int midW = ((weights[i + 1] + Math.abs(weights[i])) % 2 == 0) ? (weights[i + 1] + Math.abs(weights[i])) / 2 : (weights[i + 1] + Math.abs(weights[i])) / 2 + 1;
                    sum += weights[i + 1] - midW;
                }
            } else if (Math.abs(weights[i]) < A && Math.abs(weights[i + 1]) >= A && Math.abs(weights[i + 1]) < B) {
                if (weights[i] > 0 && weights[i + 1] > 0) {
                    sum += weights[i + 1] - A;
                } else if (weights[i] > 0 && weights[i + 1] < 0) {
                    int midW = (Math.abs(weights[i + 1]) + weights[i]) / 2;
                    if (midW >= A) {
                        sum += midW - A + 1;
                    }
                } else if (weights[i] < 0 && weights[i + 1] > 0) {
                    int midW = ((weights[i + 1] + Math.abs(weights[i])) % 2 == 0) ? (weights[i + 1] + Math.abs(weights[i])) / 2 : (weights[i + 1] + Math.abs(weights[i])) / 2 + 1;
                    if (midW <= A) {
                        sum += weights[i + 1] - A;
                    } else {
                        sum += weights[i + 1] - midW;
                    }
                }
            } else if (Math.abs(weights[i]) >= A && Math.abs(weights[i]) < B && Math.abs(weights[i + 1]) >= B) {
                if (weights[i] > 0 && weights[i + 1] > 0) {
                    sum += B - weights[i] + 1;
                } else if (weights[i] > 0 && weights[i + 1] < 0) {
                    int midW = (Math.abs(weights[i + 1]) + weights[i]) / 2;
                    if (midW < B) {
                        sum += midW - weights[i] + 1;
                    } else {
                        sum += B - weights[i] + 1;
                    }
                } else if (weights[i] < 0 && weights[i + 1] > 0) {
                    int midW = ((weights[i + 1] + Math.abs(weights[i])) % 2 == 0) ? (weights[i + 1] + Math.abs(weights[i])) / 2 : (weights[i + 1] + Math.abs(weights[i])) / 2 + 1;
                    if (midW <= B) {
                        sum += B - midW + 1;
                    }
                }
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
