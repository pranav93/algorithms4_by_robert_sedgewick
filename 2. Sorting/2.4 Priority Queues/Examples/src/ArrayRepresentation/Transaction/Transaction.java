package ArrayRepresentation.Transaction;

public class Transaction implements Comparable<Transaction> {

    String name;
    String date; // No need to care about date format for this example
    Double amount;

    public Transaction(String str) {
        String[] strArr = str.split("\\s+");
        this.name = strArr[0];
        this.date = strArr[1];
        this.amount = Double.parseDouble(strArr[2]);
    }

    @Override
    public int compareTo(Transaction t) {
        // comparing amount
        if (this.amount < t.amount) {
            return -1;
        } else if (this.amount > t.amount) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        return this.name + "\t" + this.date + "\t" + this.amount;
    }

}