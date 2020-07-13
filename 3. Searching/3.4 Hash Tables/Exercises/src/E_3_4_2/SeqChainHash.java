package E_3_4_2;

import edu.princeton.cs.algs4.Queue;

public class SeqChainHash<Key, Value> {
    SeqSearchST<Key, Value>[] st;
    int M;
    int N;

    SeqChainHash(int M) {
        this.M = M;
        this.st = (SeqSearchST<Key, Value>[]) new SeqSearchST[this.M];
        for (int i = 0; i < this.M; i++) {
            this.st[i] = new SeqSearchST<Key, Value>();
        }
    }

    int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % this.M;
    }

    public void put(Key key, Value value) {
        boolean added = this.st[this.hash(key)].put(key, value);
        if (added) {
            this.N++;
        }
    }

    public Value get(Key key) {
        return this.st[this.hash(key)].get(key);
    }

    public void delete(Key key) {
        boolean deleted = this.st[this.hash(key)].delete(key);
        if (deleted) {
            this.N--;
        }
    }

    public Iterable<String> keys() {
        Queue<String> qKeys = new Queue<String>();
        for (int i = 0; i < this.M; i++) {
            String keyInfo = "first -> ";
            for (Key keyStr : this.st[i].keys()) {
                keyInfo = keyInfo + " -> " + keyStr;
            }
            keyInfo = keyInfo + " -> null";
            qKeys.enqueue(keyInfo);
        }
        return qKeys;
    }
}
