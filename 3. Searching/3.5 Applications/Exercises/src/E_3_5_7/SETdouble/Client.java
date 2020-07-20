package E_3_5_7.SETdouble;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        double[] doubleArr = new double[] { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0 };
        
        SETdouble st = new SETdouble();

        for (int i = 0; i < doubleArr.length; i++) {
            st.add(doubleArr[i]);
        }

        for (double i : st.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        for (double i : st.keys()) {
            StdOut.println("contains " + i + " -> " + st.contains(i));
        }
        StdOut.println();
        StdOut.println("size -> " + st.size());

        st.remove(2.2);
        st.remove(5.5);
        for (double i : st.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        StdOut.println("size -> " + st.size());
        StdOut.println("2000 -> " + st.contains(2000));
    }
}