package ArrayRepresentation.Ordered;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] arr;
    private int size;

    public MinPQ() {
        this.arr = (Key[]) new Comparable[100];
    }

    public MinPQ(int max) {
        this.arr = (Key[]) new Comparable[max];
    }

    public MinPQ(Key[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            this.arr[i] = a[i];
        }
    }

    public void insert(Key v) {
        this.arr[this.size++] = v;
        for (int i = 1; i < this.size; i++) {
            if (less(this.arr[i - 1], this.arr[i])) {
                exch(this.arr, i - 1, i);
            }
        }
    }

    public Key delMin() {
        Key k = this.arr[--this.size];
        for (int i = 1; i < this.size; i++) {
            if (less(this.arr[i - 1], this.arr[i])) {
                exch(this.arr, i - 1, i);
            }
        }
        return k;
    }

    public Key min() {
        return this.arr[this.size - 1];
    }

    private void exch(Key[] arr2, int i, int i2) {
        Key temp = arr2[i];
        arr2[i] = arr2[i2];
        arr2[i2] = temp;
    }

    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}