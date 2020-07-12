package HashSepChain;

import edu.princeton.cs.algs4.Queue;

public class SequentialSearchST<Key, Value> {
    class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

    int N = 0;
    Node first;

    public Value get(Key key) {
        for (Node i = this.first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                return i.value;
            }
        }
        return null;
    }

    public boolean put(Key key, Value value) {
        if (this.first == null) {
            this.first = new Node(key, value);
            this.N++;
            return true;
        }
        Node prevNode = null;
        for (Node i = this.first; i != null; prevNode = i, i = i.next) {
            if (i.key.equals(key)) {
                i.value = value;
                return false;
            }
        }
        prevNode.next = new Node(key, value);
        this.N++;
        return true;
    }

    public int size() {
        return this.N;
    }

    public void keys(Queue<Key> qKeys) {
        for (Node i = this.first; i != null; i = i.next) {
            qKeys.enqueue(i.key);
        }
    }

    public boolean delete(Key key) {
        Node prev = null;
        for (Node i = this.first; i != null; prev = i, i = i.next) {
            if (key.equals(i.key)) {
                if (prev == null) {
                    this.first = this.first.next;
                    this.N--;
                    return true;
                }
                prev.next = i.next;
                i.next = null;
                this.N--;
                return true;
            }
        }
        return false;
    }
}
