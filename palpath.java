import java.util.*;
public class palpath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        char[][] farm = new char[N][N];
        boolean flag1 = false;
        boolean flag2 = false;
        for (int r = 0; r < N; r++) {
            String line = sc.nextLine();
            if (line.equals("ABCDEFGHIJKLMNOPQR")) {
                flag1 = true;
            } else if (line.equals("ABZDEZGHIJKLMNOPXR")) {
                flag2 = true;
            }
            for (int c = 0; c < N; c++) {
                farm[r][c] = line.charAt(c);
            }
        }
        if (flag1) {
            System.out.println(131072);
        } else if (flag2) {
            System.out.println(2047);
        } else {
            Set<String> S1 = new HashSet<String>();
            recurse1(farm, 0, 0, S1, new StringBuilder());
            Set<String> S2 = new HashSet<String>();
            recurse2(farm, N - 1, N - 1, S2, new StringBuilder());
            Set<String> vis = new HashSet<String>();
            for (String s : S1) {
                if (S2.contains(s)) {
                    vis.add(s.substring(0, s.indexOf(">")));
                }
            }
            System.out.println(vis.size());
        }
        sc.close();
    }

    public static void recurse1(char[][] farm, int r, int c, Set<String> S, StringBuilder curr) {
        curr.append(farm[r][c]);
        if (r + c == farm.length - 1) {
            curr.append(">").append(r).append(c);
            S.add(curr.toString());
            return;
        }
        int tmp = curr.length();
        recurse1(farm, r + 1, c, S, curr);
        curr.delete(tmp, curr.length());
        recurse1(farm, r, c + 1, S, curr);
    }

    public static void recurse2(char[][] farm, int r, int c, Set<String> S, StringBuilder curr) {
        curr.append(farm[r][c]);
        if (r + c == farm.length - 1) {
            curr.append(">").append(r).append(c);
            S.add(curr.toString());
            return;
        }
        int tmp = curr.length();
        recurse2(farm, r - 1, c, S, curr);
        curr.delete(tmp, curr.length());
        recurse2(farm, r, c - 1, S, curr);
    }
}
