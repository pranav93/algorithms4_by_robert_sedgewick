package E_3_1_5;

import edu.princeton.cs.algs4.Queue;

public class SequentialSearchST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    SequentialSearchST() {
        this.keys = (Key[]) new Object[1];
        this.values = (Value[]) new Object[1];
        this.N = 0;
    }

    public void put(Key key, Value value) {
        for (int i = 0; i < this.N; i++) {
            if (this.keys[i].equals(key)) {
                this.values[i] = value;
                return;
            }
        }
        this.keys[this.N] = key;
        this.values[this.N] = value;
        this.N++;

        if (this.N == this.keys.length) {
            resize(this.keys.length * 2);
        }
    }

    public void delete(Key key) {
        int i;
        for (i = 0; i < this.N; i++) {
            if (this.keys[i].equals(key)) {
                break;
            }
        }
        for (int j = i; j < this.N; j++) {
            this.keys[j] = this.keys[j + 1];
            this.values[j] = this.values[j + 1];
        }
        this.N--;

        if (this.N == this.keys.length / 4) {
            resize(this.keys.length / 2);
        }
    }

    private void resize(int size) {
        Key[] tempKeys = (Key[]) new Object[size];
        Value[] tempValues = (Value[]) new Object[size];
        for (int i = 0; i < this.N; i++) {
            tempKeys[i] = this.keys[i];
            tempValues[i] = this.values[i];
        }
        this.keys = tempKeys;
        this.values = tempValues;
    }

    public Value get(Key key) {
        for (int i = 0; i < this.N; i++) {
            if (this.keys[i].equals(key)) {
                return this.values[i];
            }
        }
        return null;
    }

    public int size() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i < this.N; i++) {
            q.enqueue(this.keys[i]);
        }
        return q;
    }

}