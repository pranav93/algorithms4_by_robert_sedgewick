package HashSepChain;

import edu.princeton.cs.algs4.Queue;

public class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        this.st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[this.M];
        for (int i = 0; i < this.M; i++) {
            this.st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % this.M;
    }

    public Value get(Key key) {
        return this.st[this.hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        boolean added = this.st[this.hash(key)].put(key, value);
        if (added) {
            this.N++;
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> qKeys = new Queue<Key>();
        for (int i = 0; i < this.M; i++) {
            this.st[i].keys(qKeys);
        }
        return qKeys;
    }
}