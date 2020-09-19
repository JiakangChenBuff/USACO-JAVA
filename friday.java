import java.util.*;
public class friday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Date d = new Date();
        int[] counter = new int[8];
        while (!(d.year == (1900 + N - 1) && d.month == 12 && d.day == 31)) {
            if (d.is13th()) {
                counter[d.weekday]++;
            }
            d.advance();
        }
        for (int i = 1; i < counter.length; i++) {
            System.out.print(counter[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}

class Date {
    public int year;
    public int month;
    public int day;
    public int weekday;

    public Date() {
        year = 1900;
        month = 1;
        day = 1;
        weekday = 3;
    }

    public void advance() {
        if (day == 28 && month == 2 && notLeapYear()) {
            day = 1;
            month++;
        } else if (day == 29 && month == 2 && !notLeapYear()) {
            day = 1;
            month++;
        } else if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            day = 1;
            month++;
        } else if (day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) {
            day = 1;
            month++;
        } else if (day == 31 && month == 12) {
            day = 1;
            month = 1;
            year++;
        } else {
            day++;
        }
        if (weekday == 7) {
            weekday = 1;
        } else {
            weekday++;
        }
    }

    public boolean is13th() {
        return day == 13;
    }

    public boolean notLeapYear() {
        return (year % 4 != 0) || (year % 4 == 0 && year % 100 == 0 && year % 400 != 0);
    }
}
