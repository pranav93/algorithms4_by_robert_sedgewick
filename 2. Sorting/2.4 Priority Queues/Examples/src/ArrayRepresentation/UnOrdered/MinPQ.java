package ArrayRepresentation.UnOrdered;

public class MinPQ<Key extends Comparable<Key>> {
    Key[] arr;
    int size;

    public MinPQ() {
        this.arr = (Key[]) new Comparable[100];
    }

    public MinPQ(int max) {
        this.arr = (Key[]) new Comparable[max];
    }

    public MinPQ(Key[] a) {
        int N = a.length;
        this.arr = (Key[]) new Comparable[N];
        for (int i = 0; i < N; i++) {
            this.arr[i] = a[i];
        }
    }

    public void insert(Key v) {
        this.arr[this.size++] = v;
    }

    public Key min() {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (this.arr[i].compareTo(this.arr[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return this.arr[minIndex];
    }

    public Key delMin() {
        int minIndex = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i].compareTo(this.arr[minIndex]) < 0) {
                minIndex = i;
            }
        }
        exch(minIndex);
        return this.arr[--this.size];
    }

    private void exch(int minIndex) {
        Key t = this.arr[minIndex];
        this.arr[minIndex] = this.arr[this.size - 1];
        this.arr[this.size - 1] = t;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }
}