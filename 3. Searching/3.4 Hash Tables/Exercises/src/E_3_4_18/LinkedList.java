package E_3_4_18;

import edu.princeton.cs.algs4.Queue;

public class LinkedList<Key, Value> {
    class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    int N;
    Node first;

    public int size() {
        return this.N;
    }

    public void put(Key key, Value value) {
        if (this.first == null) {
            this.first = new Node(key, value);
            this.N++;
        }

        Node prev = null;
        for (Node i = this.first; i != null; prev = i, i = i.next) {
            if (i.key.equals(key)) {
                i.value = value;
                return;
            }
        }
        prev.next = new Node(key, value);
        this.N++;
    }

    public Value get(Key key) {
        for (Node i = this.first; i != null; i = i.next) {
            if (key.equals(i.key)) {
                return i.value;
            }
        }
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> qKeys = new Queue<Key>();
        for (Node i = this.first; i != null; i = i.next) {
            qKeys.enqueue(i.key);
        }
        return qKeys;
    }
}