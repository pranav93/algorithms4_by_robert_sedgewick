package app.E_1_2_11;

import java.util.Arrays;

public class SmartDate {
    private final int year;
    private final int month;
    private final int date;
    private final int[] _31_date_months = { 1, 3, 5, 7, 8, 10, 12 };
    private final int[] _30_date_months = { 4, 6, 9, 11 };
    private final int monthFeb = 2;
    private final boolean isLeapYear;
    private String dayOfTheWeek;
    private Integer totalDays;
    private final String[] daysStringArr = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
            "Saturday" };

    public SmartDate(int date, int month, int year) {
        if (!(date > 0 && date < 32)) {
            throw new IllegalArgumentException("Date should be in between 1 and 31 inclusive.");
        }
        if (!(month < 13 && month > 0)) {
            throw new IllegalArgumentException("Month should be in between 1 and 12 inclusive.");
        }

        // date should be less than or equal to 30
        if (arrContains(this._30_date_months, month)) {
            if (date > 30) {
                throw new IllegalArgumentException("Illeagal date " + date + " for provided month of " + month + ".");
            }
        }

        this.isLeapYear = SmartDate.isLeapYear(year);

        if (month == this.monthFeb) {
            // check leap year
            int validLeapDate = 0;
            if (this.isLeapYear) {
                validLeapDate = 29;
            } else {
                validLeapDate = 28;
            }
            if (date > validLeapDate) {
                throw new IllegalArgumentException("Illeagal date " + date + " for provided month of " + month + ".");
            }
        }

        this.year = year;
        this.month = month;
        this.date = date;
        calculateTotalDays();
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            // common year
            return false;
        } else if (year % 100 != 0) {
            // leap year
            return true;
        } else if (year % 400 != 0) {
            // common year
            return false;
        } else {
            // leap year
            return true;
        }
    }

    private static boolean arrContains(int[] arr, int e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.date + "/" + this.month + "/" + this.year;
    }

    public String dayOfTheWeek() {
        if (this.dayOfTheWeek != null) {
            return this.dayOfTheWeek;
        }

        // find total days since 01/01/0001 -> Monday
        calculateTotalDays();
        int day = this.totalDays % 7;
        this.dayOfTheWeek = this.daysStringArr[day];
        return this.dayOfTheWeek;
    }

    private void calculateTotalDays() {
        int totalDays = 0;

        if (this.totalDays != null) {
            return;
        }

        // Total days till previous year
        for (int i = 1; i < this.year; i++) {
            totalDays += 365;
            boolean isLeapYear = SmartDate.isLeapYear(i);
            if (isLeapYear) {
                totalDays++;
            }
        }

        // Total days till previous month, in current year
        for (int i = 1; i < this.month; i++) {
            if (arrContains(this._30_date_months, i)) {
                totalDays += 30;
            } else if (arrContains(this._31_date_months, i)) {
                totalDays += 31;
            } else {
                if (this.isLeapYear) {
                    totalDays += 29;
                } else {
                    totalDays += 28;
                }
            }
        }
        totalDays += this.date;
        this.totalDays = totalDays;
    }

    public int equals(SmartDate that) {
        if (this.totalDays > that.totalDays) {
            return 1;
        } else if (this.totalDays < that.totalDays) {
            return -1;
        } else {
            return 0;
        }
    }
}