package LinkedListRepresentation.UnOrdered;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import Stack.Stack;
import Transaction.Transaction;

public class Client {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>();
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M) {
                pq.delMin();
            }
        }
        Stack<Transaction> st = new Stack<Transaction>(M + 1);
        while (!pq.isEmpty()) {
            st.push(pq.delMin());
        }

        for (Transaction transaction : st) {
            StdOut.println(transaction);
        }
    }
}