package E_3_5_6.HashSETdouble;

import edu.princeton.cs.algs4.Queue;

public class HashSETdouble {
    double[] keys;
    int M;
    int N;

    HashSETdouble() {
        this.M = 4;
        this.keys = new double[this.M];
    }

    HashSETdouble(int size) {
        this.M = size;
        this.keys = new double[this.M];
    }

    public void add(double key) {
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
        HashSETdouble t = new HashSETdouble(newSize);
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != 0) {
                t.add(this.keys[i]);
            }
        }
        this.keys = t.keys;
        this.M = t.M;
    }

    private int hash(double key) {
        return (Double.valueOf(key).hashCode() & 0x7fffffff) % this.M;
    }

    public Iterable<Double> keys() {
        Queue<Double> qKeys = new Queue<Double>();
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != 0) {
                qKeys.enqueue(this.keys[i]);
            }
        }
        return qKeys;
    }

    public boolean contains(double key) {
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

    public void remove(double key) {
        int i;
        for (i = this.hash(key); this.keys[i] != 0; i = (i + 1) % this.M) {
            if (this.keys[i] == key) {
                break;
            }
        }
        if (this.keys[i] == 0) {
            return;
        }
        this.keys[i] = 0;
        this.N--;
        i = (i + 1) % this.M;
        while (this.keys[i] != 0) {
            double temp = this.keys[i];
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