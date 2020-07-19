package E_3_5_4.HashSTint;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        int[] intArr = new int[] { 11, 22, 33, 44, 55, 66, 77, 88, 99, 100 };
        String[] strArr = new String[] { "eleven", "twenty-two", "thirty-three", "forty-four", "fifty-five",
                "sixty-six", "seventy-seven", "eighty-eight", "ninty-nine", "hundred" };
        HashSTint<String> st = new HashSTint<String>();

        for (int i = 0; i < strArr.length; i++) {
            st.put(intArr[i], strArr[i]);
        }

        for (int i : st.keys()) {
            StdOut.print("\t" + i);
        }
        StdOut.println();
        for (int i : st.keys()) {
            StdOut.println("contains " + i + " -> " + st.contains(i));
            StdOut.println("get " + i + " -> " + st.get(i));
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