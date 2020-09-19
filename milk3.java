import java.util.*;
public class milk3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        boolean[][][] possible = new boolean[A + 1][B + 1][C + 1];
        possible[0][0][C] = true;
        recurse(possible, 0, 0, C);

        Set<Integer> cVal = new TreeSet<Integer>();
        for (int i = 0; i < B + 1; i++) {
            for (int j = 0; j < C + 1; j++) {
                if (possible[0][i][j]) {
                    cVal.add(j);
                }
            }
        }
        for (Integer num : cVal) {
            System.out.print(num + " ");
        }
        System.out.println();
        sc.close();
    }

    public static void recurse(boolean[][][] possible, int A, int B, int C) {
        int maxA = possible.length - 1;
        int maxB = possible[0].length - 1;
        int maxC = possible[0][0].length - 1;

        if (maxA - A >= C && !possible[A + C][B][0]) {
            possible[A + C][B][0] = true;
            recurse(possible, A + C, B, 0);
        } else if (maxA - A < C && !possible[maxA][B][C - maxA + A]) {
            possible[maxA][B][C - maxA + A] = true;
            recurse(possible, maxA, B, C - maxA + A);
        }

        if (maxB - B >= C && !possible[A][B + C][0]) {
            possible[A][B + C][0] = true;
            recurse(possible, A, B + C, 0);
        } else if (maxB - B < C && !possible[A][maxB][C - maxB + B]) {
            possible[A][maxB][C - maxB + B] = true;
            recurse(possible, A, maxB, C - maxB + B);
        }

        if (maxA - A >= B && !possible[A + B][0][C]) {
            possible[A + B][0][C] = true;
            recurse(possible, A + B, 0, C);
        } else if (maxA - A < B && !possible[maxA][B - maxA + A][C]) {
            possible[maxA][B - maxA + A][C] = true;
            recurse(possible, maxA, B - maxA + A, C);
        }

        if (maxC - C >= B && !possible[A][0][B + C]) {
            possible[A][0][B + C] = true;
            recurse(possible, A, 0, B + C);
        } else if (maxC - C < B && !possible[A][B - maxC + C][maxC]) {
            possible[A][B - maxC + C][maxC] = true;
            recurse(possible, A, B - maxC + C, maxC);
        }

        if (maxC - C >= A && !possible[0][B][A + C]) {
            possible[0][B][A + C] = true;
            recurse(possible, 0, B, A + C);
        } else if (maxC - C < A && !possible[A - maxC + C][B][maxC]) {
            possible[A - maxC + C][B][maxC] = true;
            recurse(possible, A - maxC + C, B, maxC);
        }

        if (maxB - B >= A && !possible[0][A + B][C]) {
            possible[0][A + B][C] = true;
            recurse(possible, 0, A + B, C);
        } else if (maxB - B < A && !possible[A - maxB + B][maxB][C]) {
            possible[A - maxB + B][maxB][C] = true;
            recurse(possible, A - maxB + B, maxB, C);
        }
    }
}
