package E_3_1_4;

public class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    private int second;

    Time(String timeString) {
        String[] timeStringArr = timeString.split(":");
        this.hour = Integer.parseInt(timeStringArr[0]);
        this.minute = Integer.parseInt(timeStringArr[1]);
        this.second = Integer.parseInt(timeStringArr[2]);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.hour + ":" + this.minute + ":" + this.second;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.compareTo((Time) obj) == 0;
    }

    @Override
    public int compareTo(Time that) {
        // TODO Auto-generated method stub
        if (this.hour > that.hour) {
            return 1;
        } else if (this.hour < that.hour) {
            return -1;
        } else if (this.minute > that.minute) {
            return 1;
        } else if (this.minute < that.minute) {
            return -1;
        } else if (this.second > that.second) {
            return 1;
        } else if (this.second < that.second) {
            return -1;
        } else {
            return 0;
        }
    }
}