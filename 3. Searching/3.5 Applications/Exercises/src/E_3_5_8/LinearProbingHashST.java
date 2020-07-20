package E_3_5_8;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashST<Key, Value> {
    Key[] keys;
    Value[] values;
    int N;
    int M;

    LinearProbingHashST() {
        this.M = 4;
        this.keys = (Key[]) new Object[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    LinearProbingHashST(int cap) {
        this.M = cap;
        this.keys = (Key[]) new Object[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    public void put(Key key, Value value) {
        int i = 0;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            // iterate till null
        }
        this.keys[i] = key;
        this.values[i] = value;
        this.N++;
        if (this.N == this.M / 2) {
            this.resize(this.M * 2);
        }
    }

    private void resize(int newSize) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<Key, Value>(newSize);
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != null) {
                t.put(this.keys[i], this.values[i]);
            }
        }
        this.keys = t.keys;
        this.values = t.values;
        this.M = t.M;
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
        int i = 0;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (this.keys[i].equals(key)) {
                break;
            }
        }

        while (this.keys[i].equals(key)) {
            this.keys[i] = null;
            this.values[i] = null;
            this.N--;
            i = (i + 1) % this.M;
        }

        while (this.keys[i] != null) {
            Key tKey = this.keys[i];
            Value tValue = this.values[i];
            this.keys[i] = null;
            this.values[i] = null;
            this.N--;
            this.put(tKey, tValue);
            i = (i + 1) % this.M;
        }

        if (this.N == this.M / 8) {
            this.resize(this.M / 2);
        }

    }
}