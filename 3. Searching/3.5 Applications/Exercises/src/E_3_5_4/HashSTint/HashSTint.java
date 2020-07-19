package E_3_5_4.HashSTint;

import edu.princeton.cs.algs4.Queue;

public class HashSTint {
    int[] keys;
    int M;
    int N;

    HashSTint() {
        this.M = 4;
        this.keys = new int[this.M];
    }

    HashSTint(int size) {
        this.M = size;
        this.keys = new int[this.M];
    }

    public void add(int key) {
        if (key == 0) {
            throw new IllegalArgumentException("Value 0 not allowed");
        }
        int i;
        for (i = this.hash(key); this.keys[i] != 0; i = (i + 1) % this.M) {
            if (this.keys[i] == key) {
                return;
            }
        }
        this.keys[i] = key;
        this.N++;

        if (this.N == this.M / 2) {
            this.resize(this.M * 2);
        }
    }

    private void resize(int newSize) {
        HashSTint t = new HashSTint(newSize);
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != 0) {
                t.add(this.keys[i]);
            }
        }
        this.keys = t.keys;
        this.M = t.M;
    }

    private int hash(int key) {
        return (Integer.valueOf(key).hashCode() & 0x7fffffff) % this.M;
    }

    public Iterable<Integer> keys() {
        Queue<Integer> qKeys = new Queue<Integer>();
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != 0) {
                qKeys.enqueue(this.keys[i]);
            }
        }
        return qKeys;
    }

    public boolean contains(int key) {
        for (int i = this.hash(key); this.keys[i] != 0; i = (i + 1) % this.M) {
            if (this.keys[i] == key) {
                return true;
            }
        }
        return false;
    }

	public int size() {
		return this.N;
	}

	public void remove(int key) {
        int i;
        for (i = this.hash(key); this.keys[i] != 0; i = (i + 1) % this.M) {
            if (this.keys[i] == key) {
                break;
            }
        }
        this.keys[i] = 0;
        this.N--;
        i++;
        while (this.keys[i] != 0) {
            int temp = this.keys[i];
            this.keys[i] = 0;
            this.N--;
            this.add(temp);
            i = (i + 1) % this.M;
        }
        if (this.N == this.M / 8) {
            this.resize(this.M / 2);
        }
	}
}