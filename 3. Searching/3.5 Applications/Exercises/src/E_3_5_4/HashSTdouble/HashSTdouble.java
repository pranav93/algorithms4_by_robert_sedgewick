package E_3_5_4.HashSTdouble;

import edu.princeton.cs.algs4.Queue;

public class HashSTdouble<Value> {
    double[] keys;
    Value[] values;
    int M;
    int N;

    HashSTdouble() {
        this.M = 4;
        this.keys = new double[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    HashSTdouble(int size) {
        this.M = size;
        this.keys = new double[this.M];
        this.values = (Value[]) new Object[this.M];
    }

    public void put(double key, Value value) {
        if (key == 0) {
            throw new IllegalArgumentException("Value 0 not allowed");
        }
        int i;
        for (i = this.hash(key); this.keys[i] != 0; i = (i + 1) % this.M) {
            if (this.keys[i] == key) {
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
        HashSTdouble<Value> t = new HashSTdouble<Value>(newSize);
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != 0) {
                t.put(this.keys[i], this.values[i]);
            }
        }
        this.keys = t.keys;
        this.values = t.values;
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
        this.values[i] = null;
        this.N--;
        i++;
        while (this.keys[i] != 0) {
            double tempKey = this.keys[i];
            Value tempValue = this.values[i];
            this.keys[i] = 0;
            this.values[i] = null;
            this.N--;
            this.put(tempKey, tempValue);
            i = (i + 1) % this.M;
        }
        if (this.N == this.M / 8) {
            this.resize(this.M / 2);
        }
    }

    public Value get(double key) {
        for (int i = this.hash(key); this.keys[i] != 0; i = (i + 1) % this.M) {
            if (this.keys[i] == key) {
                return this.values[i];
            }
        }
        return null;
    }
}