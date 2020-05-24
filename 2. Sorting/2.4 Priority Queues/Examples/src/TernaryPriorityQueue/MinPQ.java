package TernaryPriorityQueue;

// First write program for binary tree / later convert it to ternary tree
public class MinPQ<Key extends Comparable<Key>> {
    Key[] arr;
    int N;

    public MinPQ(int max) {
        this.arr = (Key[]) new Comparable[max + 1];
    }

    public void insert(Key v) {
        this.arr[++this.N] = v;
        this.swim(this.N);
    }

    public Key delMin() {
        Key minVal = this.arr[1];
        this.exch(1, this.N--);
        this.arr[this.N + 1] = null;
        this.sink(1);
        return minVal;
    }

    private void sink(int k) {
        while (3 * k - 1 <= N) {
            int j = 3 * k - 1;
            if (j < N && this.less(j + 1, j)) {
                j++;
                if (j < N && this.less(j + 1, j)) {
                    j++;
                }
            } else if (j + 1 < N && this.less(j + 2, j)) {
                j += 2;
            }
            if (!this.less(j, k)) {
                break;
            }
            this.exch(j, k);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && this.less(k, (k + 1) / 3)) {
            this.exch(k, (k + 1) / 3);
            k = (k + 1) / 3;
        }
    }

    private void exch(int i, int j) {
        Key temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }

    private boolean less(int i, int j) {
        return this.arr[i].compareTo(this.arr[j]) < 0;
    }

    public int size() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }
}