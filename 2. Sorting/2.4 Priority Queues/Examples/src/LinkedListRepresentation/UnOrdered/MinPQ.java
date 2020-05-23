package LinkedListRepresentation.UnOrdered;

public class MinPQ<Key extends Comparable<Key>> {
    class Node {
        Key item;
        Node next;
        Node prev;
    }

    Node first;
    Node last;
    int size;

    MinPQ() {
    }

    MinPQ(Key v) {
        this.insert(v);
    }

    MinPQ(Key[] a) {
        for (Key key : a) {
            this.insert(key);
        }
    }

    public void insert(Key v) {
        Node temp = new Node();
        temp.item = v;
        if (this.size == 0) {
            this.first = temp;
            this.last = this.first;
        } else {
            this.last.next = temp;
            this.last.next.prev = this.last;
            this.last = this.last.next;
        }
        this.size++;
    }

    public Key min() {
        Node current = this.first;
        Node min = current;
        current = current.next;
        while (current != null) {
            if (less(current.item, min.item)) {
                min = current;
            }
            current = current.next;
        }
        return min.item;
    }

    public Key delMin() {
        if (this.size == 1) {
            Node min = this.first;
            this.first = null;
            this.last = null;
            this.size--;
            return min.item;
        }
        Node current = this.first;
        Node min = current;
        while (current != null) {
            if (less(current.item, min.item)) {
                min = current;
            }
            current = current.next;
        }
        Node minPrev = min.prev;
        Node minNext = min.next;
        if (minNext == null) {
            this.last = min.prev;
            this.last.next = null;
        } else if (minPrev == null) {
            this.first = min.next;
            this.first.prev = null;
        } else {
            minPrev.next = minNext;
            minNext.prev = minPrev;
        }
        this.size--;
        return min.item;
    }

    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}