package E_3_5_7.SETint;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        int[] intArr = new int[] { 11, 22, 33, 44, 55, 66, 77, 88, 99, 100 };
        
        SETint st = new SETint();

        for (int i = 0; i < intArr.length; i++) {
            st.add(intArr[i]);
        }

        for (int i : st.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        for (int i : st.keys()) {
            StdOut.println("contains " + i + " -> " + st.contains(i));
        }
        StdOut.println();
        StdOut.println("size -> " + st.size());

        st.remove(22);
        st.remove(55);
        for (int i : st.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        StdOut.println("size -> " + st.size());
        StdOut.println("2000 -> " + st.contains(2000));
    }
}