import java.util.*;
public class tseat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int R = sc.nextInt();
        Seat[] seats = new Seat[W * R];
        int i = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < W; c++) {
                int d = (R - 1 - r) * (R - 1 - r) + (W / 2 - c) * (W / 2 - c);
                seats[i] = new Seat(r, c, d);
                i++;
            }
        }
        sc.close();
        Arrays.sort(seats);
        int[][] priority = new int[R][W];
        for (i = 0; i < seats.length; i++) {
            priority[seats[i].r][seats[i].c] = i + 1;
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < W; c++) {
                System.out.print(priority[r][c] + " ");
            }
            System.out.println();
        }
    }
}

class Seat implements Comparable<Seat> {
    public int r;
    public int c;
    public int d;

    public Seat(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }

    public int compareTo(Seat other) {
        if (this.d == other.d) {
            if (this.r == other.r) {
                return this.c - other.c;
            } else {
                return other.r - this.r;
            }
        } else {
            return this.d - other.d;
        }
    }
}