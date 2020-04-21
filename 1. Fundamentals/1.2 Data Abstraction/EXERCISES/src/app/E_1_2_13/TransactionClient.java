package app.E_1_2_13;

import edu.princeton.cs.algs4.StdOut;

public class TransactionClient {
    public static void main(String[] args) {
        Transaction t = new Transaction("John", 100, "2/2/2020");
        StdOut.println(t.toString());
        StdOut.println(t.getDate().dayOfTheWeek());
        Transaction t1 = new Transaction("James", 100, "2/2/2020");
        StdOut.println(t.equals(t1) == 0);
    }
}