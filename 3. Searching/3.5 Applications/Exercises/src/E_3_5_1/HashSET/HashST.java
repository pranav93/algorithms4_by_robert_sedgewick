package E_3_5_1.HashSET;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class HashST<Key, Value> {
    Key[] keys;
    Value[] values;
    int M;
    int N;

    HashST(int size) {
        this.M = size;
        this.keys = (Key[]) new Object[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    HashST() {
        this.M = 4;
        this.keys = (Key[]) new Object[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    public void put(Key key, Value value) {
        int i;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (key.equals(this.keys[i])) {
                this.values[i] = value;
                return;
            }
        }
        this.keys[i] = key;
        this.values[i] = value;
        this.N++;
        if (this.N == this.M / 2) {
            this.resize(this.M * 2);
        }
    }

    private void resize(int newSize) {
        HashST<Key, Value> t = new HashST<Key, Value>(newSize);
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
        return (this.keys.hashCode() & 0x7fffffff) % this.M;
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
            if (key.equals(this.keys[i])) {
                break;
            }
        }
        if (this.keys[i] == null) {
            return;
        }
        this.keys[i] = null;
        this.values[i] = null;
        this.N--;
        i = (i + 1) % this.M;

        while (this.keys[i] != null) {
            Key tempKey = this.keys[i];
            Value tempValue = this.values[i];
            this.keys[i] = null;
            this.values[i] = null;
            this.N--;
            this.put(tempKey, tempValue);
            i = (i + 1) % this.M;
        }
        if (this.N == this.M / 8) {
            this.resize(this.M / 2);
        }
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

    public boolean isEmpty() {
        return this.N == 0;
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
}