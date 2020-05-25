package MultiwayMerge;

public class IndexMinPQ<Key extends Comparable<Key>> {
    Key items[];
    int pqMap[]; // PQ that contains the indices to items,
    // all the movement is done on indices in pqMap
    int N;
    int pqMapRev[]; // map that contains the item position in pqMap for index i

    public IndexMinPQ(int n) {
        this.items = (Key[]) new Comparable[n];
        this.pqMap = new int[n + 1];
        this.pqMapRev = new int[n];
    }

    public void insert(int i, Key v) {
        this.items[i] = v;
        this.pqMap[++this.N] = i;
        this.pqMapRev[i] = this.N;
        this.swim(this.N);
    }

    private void swim(int k) {
        while (k > 1 && this.less(k, k / 2)) {
            this.exch(k, k / 2);
            k /= 2;
        }
    }

    private void exch(int i, int j) {
        int tempRev = this.pqMapRev[this.pqMap[i]];
        int temp = this.pqMap[i];

        this.pqMapRev[this.pqMap[i]] = this.pqMapRev[this.pqMap[j]];
        this.pqMap[i] = this.pqMap[j];

        this.pqMapRev[this.pqMap[j]] = tempRev;
        this.pqMap[j] = temp;
    }

    private boolean less(int i, int j) {
        i = this.pqMap[i]; // get indices from pq
        j = this.pqMap[j]; // get indices from pq
        if (this.items[i] == null && this.items[j] != null) {
            return true;
        } else if (this.items[i] != null && this.items[j] == null) {
            return false;
        } else if (this.items[i] == null && this.items[j] == null) {
            throw new IllegalArgumentException("Both args are null");
        } else {
            return this.items[i].compareTo(this.items[j]) < 0;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && this.less(j + 1, j)) {
                j++;
            }
            if (!this.less(j, k)) {
                break;
            }
            this.exch(k, j);
            k = j;
        }
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public Key min() {
        return this.items[this.pqMap[1]];
    }

    public int delMin() {
        int minIndex = this.pqMap[1];
        this.exch(1, this.N--);
        this.sink(1);
        return minIndex;
    }

}
