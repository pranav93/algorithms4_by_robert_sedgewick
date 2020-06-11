package E_3_1_3;

import edu.princeton.cs.algs4.Queue;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
    private Node first;
    private int N;

    class Node {
        Key key;
        Value value;
        Node prev;
        Node next;
    }

    public void put(Key key, Value value) {
        Node i;
        Node prevI = null;
        for (i = this.first; i != null; i = i.next) {
            if (i.key.compareTo(key) == 0) {
                i.value = value;
                return;
            } else if (i.key.compareTo(key) > 0) {
                break;
            }
            prevI = i;
        }
        Node temp = new Node();
        temp.key = key;
        temp.value = value;

        if (isEmpty()) {
            this.first = temp; // empty ST
        } else if (prevI == null) {
            temp.next = i;
            i.prev = temp;
            this.first = temp; // temp is the smallest item
        } else if (i == null) {
            prevI.next = temp;
            temp.prev = prevI; // temp is the biggest item
        } else {
            temp.next = i;
            temp.prev = i.prev;
            i.prev.next = temp;
            i.prev = temp;
        }
        this.N++;
    }

    public Value get(Key key) {
        for (Node i = this.first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                return i.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        Node i;
        for (i = this.first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                break;
            }
        }
        if (i == null) {
            return;
        } else if (i.prev == null && i.next == null) {
            this.first = null;
            i.prev = null;
            i.next = null;
        } else if (i.prev == null) {
            this.first = i.next;
            i.next.prev = i.prev; // null
            i.next = null;
        } else if (i.next == null) {
            i.prev.next = i.next; // null
            i.prev = null;
        } else {
            i.prev.next = i.next;
            i.next.prev = i.prev;
            i.next = null;
            i.prev = null;
        }
        this.N--;
    }

    public int size() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (Node i = this.first; i != null; i = i.next) {
            q.enqueue(i.key);
        }
        return q;
    }
}