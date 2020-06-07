package E_2_5_9;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class Date {
    int day;
    int month;
    int year;
    String[] monthArr = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

    Date(String date) {
        String[] dateArr = date.split("-");
        this.day = Integer.parseInt(dateArr[0]);
        this.month = Arrays.binarySearch(monthArr, dateArr[1]);
        this.year = Integer.parseInt(dateArr[2]);
    }

    @Override
    public String toString() {
        return this.day + "-" + monthArr[this.month] + "-" + this.year;
    }

    public static void main(String[] args) {
        Date d = new Date("01-Jan-99");
        StdOut.println(d);
        StdOut.println(d.day);
        StdOut.println(d.month);
        StdOut.println(d.year);
    }
}