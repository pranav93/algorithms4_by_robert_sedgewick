package E_3_1_7;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class FrequencyCounter {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        int trials = StdIn.readInt();
        int distinctSum = 0;
        for (int j = 0; j < trials; j++) {
            ST<Integer, Integer> st = new ST<Integer, Integer>();
            for (int i = 0; i < N; i++) {
                int item = StdRandom.uniform(0, 1000);
                Integer val = st.get(item);
                if (val != null) {
                    st.put(item, val++);
                } else {
                    st.put(item, 1);
                }
            }
            StdOut.println("Distinct keys in trial " + j + " are -> " + st.size());
            distinctSum += st.size();
        }
        StdOut.println("Average distinct values are -> " + (float) distinctSum / trials);
    }
}