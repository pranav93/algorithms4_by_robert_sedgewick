package Bag;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int N;

    public void add(Item item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = this.first;
        this.first = temp;
        this.N++;
    }

    public int size() {
        return this.N;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ListIterator();
    }

    class ListIterator implements Iterator<Item> {
        Node current = first;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            Node temp = current;
            current = current.next;
            return temp.item;
        }
    }
}