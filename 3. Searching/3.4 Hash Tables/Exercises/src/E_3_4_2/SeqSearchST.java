package E_3_4_2;

import edu.princeton.cs.algs4.Queue;

public class SeqSearchST<Key, Value> {
    class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    int N;
    Node first;

    public boolean put(Key key, Value value) {
        if (this.first == null) {
            this.first = new Node(key, value);
            this.N++;
            return true;
        }
        Node prev = null;
        for (Node i = this.first; i != null; prev = i, i = i.next) {
            if (key.equals(i.key)) {
                i.value = value;
                return false;
            }
        }
        prev.next = new Node(key, value);
        this.N++;
        return true;
    }

    public Value get(Key key) {
        for (Node i = this.first; i != null; i = i.next) {
            if (key.equals(i.key)) {
                return i.value;
            }
        }
        return null;
    }

    public boolean delete(Key key) {
        Node i;
        Node prev = null;
        for (i = this.first; i != null; prev = i, i = i.next) {
            if (i.key.equals(key)) {
                break;
            }
        }
        if (i == null) {
            return false;
        }
        if (prev == null) {
            this.first = i.next;
            this.N--;
            return true;
        }
        prev.next = i.next;
        i.next = null;
        this.N--;
        return true;
    }

    public int size() {
        return this.N;
    }

    public Iterable<Key> keys() {
        Queue<Key> qKeys = new Queue<Key>();
        for (Node i = this.first; i != null; i = i.next) {
            qKeys.enqueue(i.key);
        }
        return qKeys;
    }
}