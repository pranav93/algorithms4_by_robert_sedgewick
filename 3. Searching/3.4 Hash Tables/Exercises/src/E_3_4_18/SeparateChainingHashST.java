package E_3_4_18;

import edu.princeton.cs.algs4.Queue;
// import edu.princeton.cs.algs4.StdOut;

public class SeparateChainingHashST<Key, Value> {
    LinkedList<Key, Value>[] stArr;
    int M;
    int N;
    int lgM;
    int probeSize;
    static int[] deltaPrimes = { 1, 3, 1, 5, 3, 3, 9, 3, 1, 3, 19, 15, 1, 5, 1, 3, 9, 3, 15, 3, 39, 5, 39, 57, 3, 35,
            1 };

    private SeparateChainingHashST(int probeSize, int size) {
        this.probeSize = probeSize;
        this.M = size;
        this.lgM = (int) (Math.log(this.M) / Math.log(2));
        this.stArr = (LinkedList<Key, Value>[]) new LinkedList[this.M];
        for (int i = 0; i < this.M; i++) {
            this.stArr[i] = new LinkedList<Key, Value>();
        }
    }

    SeparateChainingHashST(int probeSize) {
        this.probeSize = probeSize;
        this.M = 4;
        this.lgM = (int) (Math.log(this.M) / Math.log(2));
        this.stArr = (LinkedList<Key, Value>[]) new LinkedList[this.M];
        for (int i = 0; i < this.M; i++) {
            this.stArr[i] = new LinkedList<Key, Value>();
        }
    }

    private int hash(Key key) {
        int t = key.hashCode() & 0x7fffffff;
        if (lgM < 26) {
            t = t % ((int) Math.pow(2, lgM + 5) - deltaPrimes[lgM]);
        }
        return t % this.M;
    }

    public void put(Key key, Value value) {
        int keyHash = this.hash(key);
        int oldSize = this.stArr[keyHash].size();
        if (oldSize == this.probeSize) {
            this.resize(this.M * 2);
            oldSize = this.stArr[keyHash].size();
        }

        this.stArr[keyHash].put(key, value);
        int newSize = this.stArr[keyHash].size();
        this.N += (newSize - oldSize);
    }

    private void resize(int newSize) {
        SeparateChainingHashST<Key, Value> t = new SeparateChainingHashST<Key, Value>(this.probeSize, newSize);
        for (int i = 0; i < this.M; i++) {
            if (this.stArr[i].size() == 0) {
                continue;
            }
            for (Key key : stArr[i].keys()) {
                t.put(key, stArr[i].get(key));
            }
        }
        this.stArr = t.stArr;
        this.M = t.M;
    }

    public Value get(Key key) {
        return this.stArr[this.hash(key)].get(key);
    }

    public Iterable<String> keys() {
        Queue<String> qKeys = new Queue<String>();
        for (int i = 0; i < this.M; i++) {
            String keyInfo = "first ";
            for (Key keyStr : this.stArr[i].keys()) {
                keyInfo = keyInfo + " -> " + keyStr;
            }
            qKeys.enqueue(keyInfo);
        }
        return qKeys;
    }

    public int size() {
        return this.N;
    }
}