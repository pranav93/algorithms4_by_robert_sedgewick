package E_3_1_4;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        ST<Time, String> st = new ST<Time, String>();
        st.put(new Time("09:00:00"), "Chicago");
        st.put(new Time("09:00:03"), "Phoenix");
        st.put(new Time("09:00:13"), "Houston");

        String val = st.get(new Time("09:00:00"));
        StdOut.println(val);
        val = st.get(new Time("09:00:03"));
        StdOut.println(val);
        val = st.get(new Time("09:00:13"));
        StdOut.println(val);
    }
}