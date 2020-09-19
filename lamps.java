import java.util.*;
public class lamps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] master = new int[N];
        for (int i = 0; i < N; i++) {
            master[i] = 2;
        }
        int C = sc.nextInt();
        while (sc.hasNext()) {
            int x = sc.nextInt() - 1;
            if (x == -2) {
                break;
            } else {
                master[x] = 1;
            }
        }

        while (sc.hasNext()) {
            int x = sc.nextInt() - 1;
            if (x == -2) {
                break;
            } else {
                master[x] = 0;
            }
        }

        int count = 0;
        ArrayList<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < 16; i++) {
            int f1 = (i & 1);
            int f2 = (i & 2) >> 1;
            int f3 = (i & 4) >> 2;
            int f4 = (i & 8) >> 3;
            int sum = f1 + f2 + f3 + f4;
            if (sum > C || (sum % 2 != C % 2)) {
                continue;
            }
            int[] curr = new int[N];
            for (int j = 0; j < N; j++) {
                curr[j] = 1;
            }

            if (f1 == 1) {
                for (int j = 0; j < N; j++) {
                    curr[j] = curr[j] == 0 ? 1 : 0;
                }
            }

            if (f2 == 1) {
                for (int j = 0; j < N; j += 2) {
                    curr[j] = curr[j] == 0 ? 1 : 0;
                }
            }

            if (f3 == 1) {
                for (int j = 1; j < N; j += 2) {
                    curr[j] = curr[j] == 0 ? 1 : 0;
                }
            }

            if (f4 == 1) {
                for (int j = 0; j < N; j += 3) {
                    curr[j] = curr[j] == 0 ? 1 : 0;
                }
            }

            if (equal(curr, master)) {
                count++;
                res.add(curr);
            }
        }
        if (count == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            Collections.sort(res, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    for (int i = 0; i < a.length; i++) {
                        if (a[i] > b[i]) {
                            return 1;
                        } else if (b[i] > a[i]) {
                            return -1;
                        }
                    }
                    return 0;
                }
            });
            for (int[] arr : res) {
                for (int num : arr) {
                    System.out.print(num);
                }
                System.out.println();
            }
        }
        sc.close();
    }

    public static boolean equal(int[] curr, int[] master) {
        for (int i = 0; i < curr.length; i++) {
            if (curr[i] != master[i] && master[i] != 2) {
                return false;
            }
        }
        return true;
    }
}
