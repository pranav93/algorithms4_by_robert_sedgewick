package E_1_3_9;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class StackStr implements Iterable<String> {
    class Node {
        String item;
        Node next;
    }

    private Node first;
    private int N;

    public void push(String item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = this.first;
        this.first = temp;
        this.N++;
    }

    public String pop() {
        Node temp = this.first;
        this.first = this.first.next;
        temp.next = null;
        this.N--;
        return temp.item;
    }

    public String top() {
        return this.first.item;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public void stackContents() {
        StdOut.printf("HEAD -> \t");
        for (Node current = this.first; current != null; current = current.next) {
            StdOut.printf("Node [ %s ] ->\t", current.item);
        }
        StdOut.printf("NULL\n");
    }

    @Override
    public Iterator<String> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }

    class StackIterator implements Iterator<String> {
        Node current = first;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public String next() {
            // TODO Auto-generated method stub
            String item = current.item;
            current = current.next;
            return item;
        }

    }
}