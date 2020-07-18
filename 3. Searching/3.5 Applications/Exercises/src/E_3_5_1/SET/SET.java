package E_3_5_1.SET;

import edu.princeton.cs.algs4.ST;

public class SET<Key extends Comparable<Key>> {
    ST<Key, Boolean> st = new ST<Key, Boolean>();

    public void add(Key key) {
        this.st.put(key, true);
    }

    public boolean contains(Key key) {
        return this.st.contains(key);
    }

    public void remove(Key key) {
        this.st.delete(key);
    }

    public boolean isEmpty() {
        return this.st.size() == 0;
    }

    public int size() {
        return this.st.size();
    }

    public Iterable<Key> keys() {
        return this.st.keys();
    }
}