package LinearProbing;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(int cap) {
        this.M = cap;
        this.keys = (Key[]) new Object[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    public LinearProbingHashST() {
        this.keys = (Key[]) new Object[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % this.M;
    }

    public Value get(Key key) {
        for (int i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (this.keys[i].equals(key)) {
                return this.values[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        int i;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (this.keys[i].equals(key)) {
                break;
            }
        }
        if (this.keys[i] == null) {
            // no match found
            return;
        }
        this.keys[i] = null;
        this.values[i] = null;
        i = (i + 1) % this.M;
        while (this.keys[i] != null) {
            Key tempK = this.keys[i];
            Value tempV = this.values[i];
            this.keys[i] = null;
            this.values[i] = null;
            this.put(tempK, tempV);
            i = (i + 1) % this.M;
        }
        this.N--;
        if (this.N > 0 && this.N <= this.M / 8) {
            this.resize(this.M / 2);
        }
    }

    public void put(Key key, Value value) {

        if (this.N >= this.M / 2) {
            this.resize(2 * M);
        }

        int i;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (this.keys[i].equals(key)) {
                this.values[i] = value;
                return;
            }
        }
        this.keys[i] = key;
        this.values[i] = value;
        this.N++;
    }

    private void resize(int newSize) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(newSize);
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != null) {
                t.put(this.keys[i], this.values[i]);
            }
        }
        this.keys = t.keys;
        this.values = t.values;
        this.M = t.M;
    }

    public Iterable<Key> keys() {
        Queue<Key> qKey = new Queue<Key>();
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != null) {
                qKey.enqueue(this.keys[i]);
            }
        }
        return qKey;
    }
}