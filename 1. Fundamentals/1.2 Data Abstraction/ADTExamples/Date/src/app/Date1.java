package app;

public class Date1 {
    private final int month;
    private final int day;
    private final int year;

    Date1(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int month() {
        return this.month;
    }

    public int day() {
        return this.day;
    }

    public int year() {
        return this.year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }
}