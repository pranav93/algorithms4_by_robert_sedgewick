package app.E_1_2_13;

import java.util.UUID;

import app.E_1_2_11.SmartDate;

public class Transaction {
    private final SmartDate date;
    private final double amount;
    private final String name;
    private final String id;

    Transaction(String name, double amount, String date) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.amount = amount;
        String[] dateArr = date.split("/");
        this.date = new SmartDate(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]),
                Integer.parseInt(dateArr[2]));
    }

    public String toString() {
        return "{ " + "id -> " + this.id + ",\n" + "name -> " + this.name + ",\n" + "amount -> " + this.amount + ",\n"
                + "date -> " + this.date.toString() + " }";
    }

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

    public SmartDate getDate() {
        return this.date;
    }

    public int equals(Transaction that) {
        if (this.amount == that.amount) {
            if (this.date.equals(that.date) == 0) {
                return 0;
            } else if (this.date.equals(that.date) < 0) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.amount < that.amount) {
            return -1;
        } else {
            return 1;
        }
    }
}