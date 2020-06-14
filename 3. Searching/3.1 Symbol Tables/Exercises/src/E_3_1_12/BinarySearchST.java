package E_3_1_12;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Node<Key, Value>[] arr;
    private int N;

    public BinarySearchST(Node<Key, Value>[] initArr) {
        this.N = initArr.length;
        this.arr = (Node<Key, Value>[]) new Node[this.N];
        for (int i = 0; i < this.N; i++) {
            this.arr[i] = initArr[i];
        }
        new MergeSort<Node<Key, Value>>(this.arr);
        resize(this.N * 2);
    }

    public BinarySearchST() {
        this.N = 0;
        this.arr = (Node<Key, Value>[]) new Node[1];
    }

    public Value get(Key key) {
        int i = rank(key);
        if (i < this.N && this.arr[i].key.compareTo(key) == 0) {
            return this.arr[i].value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < this.N && this.arr[i].key.compareTo(key) == 0) {
            this.arr[i].value = value;
            return;
        }
        for (int j = this.N - 1; j >= i; j--) {
            this.arr[j + 1] = this.arr[j];
        }
        this.arr[i] = new Node<Key, Value>(key, value);
        this.N++;

        if (this.N == this.arr.length) {
            resize(this.arr.length * 2);
        }
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i >= 0 && i < this.N && this.arr[i].key.compareTo(key) == 0) {
            for (int j = i; j < this.N; j++) {
                this.arr[j] = this.arr[j + 1];
            }
            this.N--;
            if (this.N == this.arr.length / 4) {
                resize(this.arr.length / 2);
            }
        }
    }

    private void resize(int size) {
        Node<Key, Value>[] tempNodeArr = (Node<Key, Value>[]) new Node[size];
        for (int i = 0; i < this.N; i++) {
            tempNodeArr[i] = this.arr[i];
        }
        this.arr = tempNodeArr;
    }

    private int rank(Key key) {
        int lo = 0;
        int hi = this.N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(this.arr[mid].key);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public int size() {
        return this.N;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i < this.N; i++) {
            q.enqueue(this.arr[i].key);
        }
        return q;
    }
}