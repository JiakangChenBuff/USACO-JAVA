import java.util.*;
public class wrongdir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Point[] moves = {new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0)};
        Point[] offsets = new Point[line.length() + 1];
        Point curr = new Point(0, 0);
        int j = 0;
        offsets[line.length()] = curr.copy();
        for (int i = line.length() - 1; i >= 0; i--) {
            if (line.charAt(i) == 'F') {
                curr.add(moves[j]);
            } else {
                curr = curr.rotate(line.charAt(i));
            }
            offsets[i] = curr.copy();
        }
        Set<Point> result = new HashSet<>();
        curr = new Point(0, 0);
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'F') {
                Point tmp = curr.copy();
                tmp.add(offsets[i + 1].rotate(map(mod4(j - 1))));
                result.add(tmp);
                tmp = curr.copy();
                tmp.add(offsets[i + 1].rotate(map(mod4(j + 1))));
                result.add(tmp);
                curr.add(moves[j]);
            } else if (line.charAt(i) == 'L') {
                Point tmp = curr.copy();
                tmp.add(offsets[i + 1].rotate(map(mod4(j + 1))));
                result.add(tmp);
                tmp = curr.copy();
                tmp.add(moves[j]);
                tmp.add(offsets[i + 1].rotate(map(j)));
                result.add(tmp);
                j = mod4(j - 1);
            } else {
                Point tmp = curr.copy();
                tmp.add(offsets[i + 1].rotate(map(mod4(j - 1))));
                result.add(tmp);
                tmp = curr.copy();
                tmp.add(moves[j]);
                tmp.add(offsets[i + 1].rotate(map(j)));
                result.add(tmp);
                j = mod4(j + 1);
            }
        }
        System.out.println(result.size());
        sc.close();
    }

    public static char map(int i) {
        switch (i) {
            case 1:
                return 'R';
            case 2:
                return 'D';
            case 3:
                return 'L';
            default:
                return 'U';
        }
    }

    public static int mod4(int i) {
        if (i < 0) {
            i += 4;
        } else if (i >= 4) {
            i -= 4;
        }
        return i;
    }
}

class Point {
    public int[] coord;

    public Point(int x, int y) {
        coord = new int[] {x, y};
    }

    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        Point other = (Point) o;
        return other.coord[0] == this.coord[0] && other.coord[1] == this.coord[1];
    }

    public int hashCode() {
        return Arrays.hashCode(coord);
    }

    public void add(Point other) {
        coord[0] += other.coord[0];
        coord[1] += other.coord[1];
    }

    public Point rotate(char dir) {
        Point result = this.copy();
        if (dir == 'L') {
            result.coord[0] = -1 * coord[1];
            result.coord[1] = coord[0];
        } else if (dir == 'R') {
            result.coord[0] = coord[1];
            result.coord[1] = -1 * coord[0];
        } else if (dir == 'D') {
            result.coord[0] = -1 * coord[0];
            result.coord[1] = -1 * coord[1];
        }
        return result;
    }

    public Point copy() {
        return new Point(coord[0], coord[1]);
    }
}