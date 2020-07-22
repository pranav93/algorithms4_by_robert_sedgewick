package E_3_5_16;

import edu.princeton.cs.algs4.ST;

public class SparseVector {
    private ST<Integer, Double> st;

    public SparseVector() {
        st = new ST<Integer, Double>();
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

    public SparseVector add(SparseVector that) {
        SparseVector sum = new SparseVector();
        for (int i : this.st.keys()) {
            double sumF = this.get(i) + that.get(i);
            if (sumF <= 0.0001 && sumF >= -0.0001) {
                continue;
            }
            sum.put(i, this.get(i) + that.get(i));
        }
        for (int i : that.st.keys()) {
            if (sum.st.contains(i)) {
                continue;
            }
            double sumF = this.get(i) + that.get(i);
            if (sumF <= 0.0001 && sumF >= -0.0001) {
                continue;
            }
            sum.put(i, this.get(i) + that.get(i));
        }
        return sum;
    }

	public Iterable<Integer> keys() {
		return this.st.keys();
	}
}