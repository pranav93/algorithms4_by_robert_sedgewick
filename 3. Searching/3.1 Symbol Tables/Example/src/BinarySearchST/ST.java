package BinarySearchST;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class ST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    ST(int cap) {
        this.keys = (Key[]) new Comparable[cap];
        this.values = (Value[]) new Object[cap];
    }

    public int size() {
        return this.N;
    }

    public Value get(Key key) {
        int i = rank(key);
        if (i < this.N && this.keys[i].compareTo(key) == 0) {
            return this.values[i];
        }
        return null;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < this.N && this.keys[i].compareTo(key) == 0) {
            this.values[i] = value;
            return;
        }

        if (this.N == this.keys.length) {
            resize(this.N * 2);
        }

        for (int j = this.N; j > i; j--) {
            this.keys[j] = this.keys[j - 1];
            this.values[j] = this.values[j - 1];
        }
        this.keys[i] = key;
        this.values[i] = value;
        this.N++;
    }

    private void resize(int size) {
        Key[] tempKeys = (Key[]) new Comparable[size];
        Value[] tempValues = (Value[]) new Object[size];
        for (int i = 0; i < this.N; i++) {
            tempKeys[i] = this.keys[i];
            tempValues[i] = this.values[i];
        }
        this.keys = tempKeys;
        this.values = tempValues;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < this.N && this.keys[i].compareTo(key) == 0) {
            for (int j = i; j < this.N; j++) {
                // StdOut.println("key -> " + this.keys[j]);
                this.keys[j] = this.keys[j + 1];
                this.keys[j] = this.keys[j + 1];
            }
            this.N--;
            if (this.N == this.keys.length / 4) {
                resize(this.keys.length / 2);
            }
        }
    }

    private int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(this.keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(this.keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(this.keys[rank(hi)]);
        }
        return q;
    }

    private boolean contains(Key hi) {
        for (int i = 0; i < this.N; i++) {
            if (this.keys[i].compareTo(hi) == 0) {
                return true;
            }
        }
        return false;
    }

    public Key min() {
        return this.keys[0];
    }

    public Key max() {
        return this.keys[this.N - 1];
    }

    public Key select(int k) {
        return this.keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return this.keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (--i < 0) {
            return null;
        }
        return this.keys[i];
    }
}