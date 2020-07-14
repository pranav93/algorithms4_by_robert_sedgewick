package E_3_4_4;

import edu.princeton.cs.algs4.Queue;

public class SeqChainHash<Value> {
    SeqSearchST<String, Value>[] st;
    int M;
    int N;
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    SeqChainHash(int M) {
        this.M = M;
        this.st = (SeqSearchST<String, Value>[]) new SeqSearchST[this.M];
        for (int i = 0; i < this.M; i++) {
            this.st[i] = new SeqSearchST<String, Value>();
        }
    }

    int hash(String key) {
        return 11 * str.indexOf(key) % this.M;
    }

    public void put(String key, Value value) {
        boolean added = this.st[this.hash(key)].put(key, value);
        if (added) {
            this.N++;
        }
    }

    public Value get(String key) {
        return this.st[this.hash(key)].get(key);
    }

    public Iterable<String> keys() {
        Queue<String> qKeys = new Queue<String>();
        for (int i = 0; i < this.M; i++) {
            String keyInfo = "first -> ";
            for (String keyStr : this.st[i].keys()) {
                keyInfo = keyInfo + " -> " + keyStr;
            }
            keyInfo = keyInfo + " -> null";
            qKeys.enqueue(keyInfo);
        }
        return qKeys;
    }
}
