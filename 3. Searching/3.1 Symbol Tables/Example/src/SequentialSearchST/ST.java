package SequentialSearchST;

import java.util.Iterator;

public class ST<Key, Value> implements Iterable<Key> {
    private Node first;
    private int N;

    class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value) {
        boolean found = false;
        for (Node i = this.first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                i.value = value;
                found = true;
                break;
            }
        }
        if (!found) {
            this.first = new Node(key, value, this.first);
            this.N++;
        }
    }

    public Value get(Key key) {
        for (Node i = this.first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                return i.value;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void delete(Key key) {
        Node prevI = null;
        for (Node i = this.first; i != null; prevI = i, i = i.next) {
            if (i.key.equals(key)) {
                if (prevI == null) {
                    this.first = i.next;
                } else {
                    prevI.next = i.next;
                }
                i.next = null;
                this.N--;
                break;
            }
        }
    }

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub
        return new KeyIterator();
    }

    class KeyIterator implements Iterator<Key> {
        Node current = first;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public Key next() {
            // TODO Auto-generated method stub
            Key k = current.key;
            current = current.next;
            return k;
        }
    }
}