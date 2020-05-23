package LinkedListRepresentation.Ordered;

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

        Node newNode = new Node();
        newNode.item = v;

        if (this.size == 0) {
            this.first = newNode;
            this.last = this.first;
            this.size++;
            return;
        }

        Node current = this.last;
        while (current != null) {
            if (less(newNode.item, current.item)) {
                break;
            }
            current = current.prev;
        }

        if (current == null) {
            this.first.prev = newNode;
            newNode.next = this.first;
            this.first = this.first.prev;
        } else if (current == this.last) {
            current.next = newNode;
            newNode.prev = current;
            this.last = this.last.next;
        } else {
            newNode.next = current.next;
            newNode.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
        }
        this.size++;
    }

    public Key min() {
        return this.last.item;
    }

    public Key delMin() {
        if (this.size == 1) {
            Node min = this.first;
            this.first = null;
            this.last = null;
            this.size--;
            return min.item;
        }
        this.size--;
        Node min = this.last;
        this.last = this.last.prev;
        this.last.next = null;
        min.prev = null;
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