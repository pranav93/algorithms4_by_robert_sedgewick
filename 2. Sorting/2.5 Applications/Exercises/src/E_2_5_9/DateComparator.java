package E_2_5_9;

import java.util.Comparator;

public class DateComparator implements Comparator<Date> {

    @Override
    public int compare(Date d1, Date d2) {
        if (d1.year > d2.year) {
            return 1;
        } else if (d1.year < d2.year) {
            return -1;
        } else if (d1.month > d2.month) {
            return 1;
        } else if (d1.month < d2.month) {
            return -1;
        } else if (d1.day > d2.day) {
            return 1;
        } else if (d1.day < d2.day) {
            return -1;
        } else {
            return 0;
        }
    }
}