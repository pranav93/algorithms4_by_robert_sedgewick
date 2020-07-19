package E_3_5_5.STint;

public class SparseVector {
    private STint st;

    public SparseVector() {
        st = new STint();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, int x) {
        st.put(i, x);
    }

    public int get(int i) {
        if (st.contains(i)) {
            return st.get(i);
        }
        return 0;
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : this.st.keys()) {
            sum += this.st.get(i) * that[i];
        }
        return sum;
    }

}