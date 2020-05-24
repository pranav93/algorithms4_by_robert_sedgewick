package ArrayResizingHeapPQ;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;
    private int arrSize = 0;

    public MaxPQ(int maxN) {
        this.pq = (Key[]) new Comparable[maxN + 1];
        this.arrSize = maxN; // 0th index is unused
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void insert(Key v) {
        if (this.N == this.arrSize) {
            this.resizeArr(2 * this.arrSize);
        }
        this.pq[++this.N] = v;
        this.swim(this.N);
    }

    private void resizeArr(int newSize) {
        Key[] tempArr = (Key[]) new Comparable[newSize + 1];
        for (int i = 1; i <= this.N; i++) {
            tempArr[i] = this.pq[i];
        }
        this.arrSize = newSize;
        this.pq = tempArr;
    }

    public Key delMax() {
        Key max = this.pq[1];
        this.exch(1, this.N--);
        this.pq[this.N + 1] = null;
        this.sink(1);
        if (this.N == this.arrSize / 4) {
            this.resizeArr(this.arrSize / 2);
        }
        return max;
    }

    private void sink(int k) {
        while (2 * k <= this.N) {
            int j = 2 * k;
            if (j < this.N && this.less(j, j + 1)) {
                j++;
            }
            if (!this.less(k, j)) {
                break;
            }
            this.exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && this.less(k / 2, k)) {
            this.exch(k / 2, k);
            k = k / 2;
        }
    }

    private void exch(int i, int j) {
        Key temp = this.pq[i];
        this.pq[i] = this.pq[j];
        this.pq[j] = temp;
    }

    private boolean less(int i, int j) {
        return this.pq[i].compareTo(this.pq[j]) < 0;
    }
}