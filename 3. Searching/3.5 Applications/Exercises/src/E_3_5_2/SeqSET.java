package E_3_5_2;

import edu.princeton.cs.algs4.Queue;

public class SeqSET<Key> {
    class Node {
        Key key;
        Node next;

        public Node(Key key) {
            this.key = key;
        }
    }

    int N;
    Node first;

    public void add(Key key) {
        if (this.first == null) {
            this.first = new Node(key);
            this.N++;
            return;
        }
        Node prev = null;
        for (Node i = this.first; i != null; prev = i, i = i.next) {
            if (i.key.equals(key)) {
                return;
            }
        }
        prev.next = new Node(key);
        this.N++;
    }

    public boolean contains(Key key) {
        for (Node i = this.first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void remove(Key key) {
        Node prev = null;
        Node i = null;
        for (i = this.first; i != null; prev = i, i = i.next) {
            if (i.key.equals(key)) {
                break;
            }
        }
        if (i == null) {
            return;
        }
        prev.next = i.next;
        i.next = null;
        this.N--;
    }

    public int size() {
        return this.N;
    }

    public Iterable<Key> keys () {
        Queue<Key> qKey = new Queue<Key>();
        for (Node i = this.first; i != null; i = i.next) {
            qKey.enqueue(i.key);
        }
        return qKey;
    }
}