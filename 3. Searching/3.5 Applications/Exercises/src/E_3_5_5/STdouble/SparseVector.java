package E_3_5_5.STdouble;

public class SparseVector {
    private STdouble st;

    public SparseVector() {
        st = new STdouble();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, double x) {
        st.put(i, x);
    }

    public double get(int i) {
        if (st.contains(i)) {
            return st.get(i);
        }
        return 0.0;
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : this.st.keys()) {
            sum += this.st.get(i) * that[i];
        }
        return sum;
    }

}