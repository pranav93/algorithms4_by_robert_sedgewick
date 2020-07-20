package E_3_5_11;

import edu.princeton.cs.algs4.Queue;

public class MultiSET<Key> {
    Key[] keys;
    int M;
    int N;

    MultiSET() {
        this.M = 4;
        this.keys = (Key[]) new Object[this.M];
    }

    MultiSET(int size) {
        this.M = size;
        this.keys = (Key[]) new Object[this.M];
    }

    public void add(Key key) {
        int i;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            // find next position to insert
        }
        this.keys[i] = key;
        this.N++;

        if (this.N == this.M / 2) {
            this.resize(this.M * 2);
        }
    }

    private void resize(int newSize) {
        MultiSET<Key> t = new MultiSET<Key>(newSize);
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != null) {
                t.add(this.keys[i]);
            }
        }
        this.keys = t.keys;
        this.M = t.M;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % this.M;
    }

    public Iterable<Key> keys() {
        Queue<Key> qKeys = new Queue<Key>();
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != null) {
                qKeys.enqueue(this.keys[i]);
            }
        }
        return qKeys;
    }

    public boolean contains(Key key) {
        for (int i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (this.keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.N;
    }

    public void remove(Key key) {
        int i;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (this.keys[i].equals(key)) {
                break;
            }
        }
        if (this.keys[i] == null) {
            return;
        }
        this.keys[i] = null;
        this.N--;
        i = (i + 1) % this.M;
        while (this.keys[i] != null) {
            if (this.keys[i].equals(key)) {
                this.keys[i] = null;
                this.N--;
            } else {
                Key temp = this.keys[i];
                this.keys[i] = null;
                this.N--;
                this.add(temp);
            }
            i = (i + 1) % this.M;
        }
        if (this.N == this.M / 8) {
            this.resize(this.M / 2);
        }
    }
}