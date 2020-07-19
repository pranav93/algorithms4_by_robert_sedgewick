package E_3_5_4.HashSTdouble;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        double[] doubleArr = new double[] { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0 };
        String[] strArr = new String[] { "one-dot-one", "two-dot-two", "three-dot-three", "four-dot-four",
                "five-dot-five", "six-dot-six", "seven-dot-seven", "eight-dot-eight", "nine-dot-nine", "ten-dot-zero" };
        HashSTdouble<String> st = new HashSTdouble<String>();

        for (int i = 0; i < strArr.length; i++) {
            st.put(doubleArr[i], strArr[i]);
        }

        for (double i : st.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        for (double i : st.keys()) {
            StdOut.println("contains " + i + " -> " + st.contains(i));
            StdOut.println("get " + i + " -> " + st.get(i));
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