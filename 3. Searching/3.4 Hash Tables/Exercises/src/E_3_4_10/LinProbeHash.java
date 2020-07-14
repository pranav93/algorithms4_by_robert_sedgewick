package E_3_4_10;

import edu.princeton.cs.algs4.Queue;

public class LinProbeHash<Value> {
    String[] keys;
    Value[] values;
    int M = 16;
    int N;
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    LinProbeHash(int size) {
        this.M = size;
        this.keys = new String[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    LinProbeHash() {
        this.keys = new String[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    int hash(String key) {
        return 11 * str.indexOf(key) % this.M;
    }

    public void put(String key, Value value) {
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

    public void delete(String key) {
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
            String tempKey = this.keys[i];
            Value tempVal = this.values[i];
            this.keys[i] = null;
            this.values[i] = null;
            this.N--;
            this.put(tempKey, tempVal);
            i = (i + 1) % this.M;
        }
        if (this.N > 0 && this.N <= this.M / 8) {
            this.resize(this.M / 2);
        }
    }

    private void resize(int newSize) {
        LinProbeHash<Value> t = new LinProbeHash<Value>(newSize);
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != null) {
                t.put(this.keys[i], this.values[i]);
            }
        }
        this.M = t.M;
        this.keys = t.keys;
        this.values = t.values;
    }

    public Value get(String key) {
        for (int i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (key.equals(this.keys[i])) {
                return this.values[i];
            }
        }
        return null;
    }

    public Iterable<String> keys() {
        Queue<String> qKeys = new Queue<String>();
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != null) {
                qKeys.enqueue(this.keys[i]);
            }
        }
        return qKeys;
    }

	public int size() {
		return this.N;
	}
}
