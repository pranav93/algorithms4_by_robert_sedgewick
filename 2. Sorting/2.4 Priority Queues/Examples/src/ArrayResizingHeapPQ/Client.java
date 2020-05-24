package ArrayResizingHeapPQ;

import Stack.Stack;
import Transaction.Transaction;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        // int M = Integer.parseInt(args[0]);
        MaxPQ<Transaction> pq = new MaxPQ<Transaction>(1);
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            // if (pq.size() > M) {
            // pq.delMax();
            // }
        }
        Stack<Transaction> st = new Stack<Transaction>(pq.size() + 1);
        while (!pq.isEmpty()) {
            st.push(pq.delMax());
        }

        for (Transaction transaction : st) {
            StdOut.println(transaction);
        }
    }
}