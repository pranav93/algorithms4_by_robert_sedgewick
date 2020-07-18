package E_3_5_1.HashSET;

public class HashSET<Key> {
    HashST<Key, Boolean> st = new HashST<Key, Boolean>();

    public void add(Key key) {
        this.st.put(key, null);
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