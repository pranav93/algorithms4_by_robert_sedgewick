package E_3_4_20;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class LinProbeHash<Key, Value> {
    Key[] keys;
    Value[] values;
    int N;
    int M;
    int searchHitTotal = 0;
    int searchMissTotal = 0;
    int accessCount = 0;

    LinProbeHash(int size) {
        this.M = size;
        this.keys = (Key[]) new Object[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    LinProbeHash() {
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
        LinProbeHash<Key, Value> t = new LinProbeHash<Key, Value>(newSize);
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
        return (this.keys.hashCode() & 0xfffffff) % this.M;
    }

    public Value get(Key key) {
        int count = 0;
        this.accessCount++;
        for (int i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            count++;
            if (key.equals(this.keys[i])) {
                this.searchHitTotal += count;
                return this.values[i];
            }
        }
        this.searchMissTotal += count;
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != null) {
                q.enqueue(this.keys[i]);
            }
        }
        return q;
    }

    public int size() {
        return this.N;
    }

    public void searchHit() {
        StdOut.println("SearchHitAvg -> " + (float) this.searchHitTotal / this.accessCount);
        StdOut.println("SearchMissAvg -> " + (float) this.searchMissTotal / this.accessCount);
    }
}