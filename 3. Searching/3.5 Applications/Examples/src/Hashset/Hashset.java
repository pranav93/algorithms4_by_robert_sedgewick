package Hashset;

public class Hashset<Key> {
    Key[] keys;
    int M;
    int N;

    public Hashset() {
        this.M = 4;
        this.N = 0;
        this.keys = (Key[]) new Object[this.M];
    }

    Hashset(int size) {
        this.M = size;
        this.N = 0;
        this.keys = (Key[]) new Object[this.M];
    }

    public void delete(Key key) {
        int i;
        for (i = this.hash(key); i < keys.length; i = (i + 1) % this.M) {
            if (key.equals(this.keys[i])) {
                break;
            }
        }
        if (this.keys[i] == null) {
            return;
        }
        this.keys[i] = null;
        this.N--;
        i = (i + 1) % this.M;
        while (this.keys[i] != null) {
            Key tempKey = this.keys[i];
            this.keys[i] = null;
            this.N--;
            this.add(tempKey);
            i = (i + 1) % this.M;
        }
        if (this.N == this.M / 8) {
            this.resize(this.M / 2);
        }
    }

    public void add(Key key) {
        int i;
        for (i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (this.keys[i].equals(key)) {
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
        Hashset<Key> t = new Hashset<Key>(newSize);
        for (int i = 0; i < this.M; i++) {
            if (this.keys[i] != null) {
                t.add(this.keys[i]);
            }
        }
        this.keys = t.keys;
        this.M = t.M;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % this.M;
    }

    public boolean contains(Key key) {
        for (int i = this.hash(key); this.keys[i] != null; i = (i + 1) % this.M) {
            if (this.keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public String toString() {
        String str = "(";
        for (int i = 0; i < keys.length; i++) {
            if (this.keys[i] != null) {
                str += this.keys[i];
            }
        }
        str += ")";
        return str;
    }
}