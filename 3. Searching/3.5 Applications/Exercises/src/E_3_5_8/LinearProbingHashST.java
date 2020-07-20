package E_3_5_8;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashST<Key, Value> {
    Key[] keys;
    Queue<Value>[] values;
    int N;
    int M;

    LinearProbingHashST() {
        this.M = 4;
        this.keys = (Key[]) new Object[this.M];
        this.values = (Queue<Value>[]) new Queue[this.M];
    }

    LinearProbingHashST(int cap) {
        this.M = cap;
        this.keys = (Key[]) new Object[this.M];
        this.values = (Queue<Value>[]) new Queue[this.M];
    }

    public void put(Key key, Value value) {
        int i = 0;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (this.keys[i].equals(key)) {
                this.values[i].enqueue(value);
                return;
            }
        }
        this.keys[i] = key;
        this.values[i] = new Queue<Value>();
        this.values[i].enqueue(value);
        this.N++;
        if (this.N == this.M / 2) {
            this.resize(this.N * 2);
        }
    }

    public void put(Key key, Queue<Value> valueQ) {
        int i = 0;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            // find next position to insert
        }
        this.keys[i] = key;
        this.values[i] = valueQ;
        this.N++;
        // no need to resize
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
                return this.values[i].peek();
            }
        }
        return null;
    }
}