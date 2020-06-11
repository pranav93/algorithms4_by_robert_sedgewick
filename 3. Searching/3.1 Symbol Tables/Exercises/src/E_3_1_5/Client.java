package E_3_1_5;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        SequentialSearchST<String, String> st = new SequentialSearchST<String, String>();
        st.put("Lindelof", "CB");
        st.put("Maguire", "CB");
        st.put("Shaw", "LB");
        st.put("WanBissaka", "RB");
        StdOut.println("WanBissaka -> " + st.get("WanBissaka"));
        StdOut.println("Shaw -> " + st.get("Shaw"));
        StdOut.println("Martial -> " + st.get("Martial"));
        StdOut.println("-----------------------------------");
        for (String str : st.keys()) {
            StdOut.println(str);
        }
        st.delete("Shaw");
        StdOut.println("Shaw -> " + st.get("Shaw"));
        StdOut.println("-----------------------------------");
        for (String str : st.keys()) {
            StdOut.println(str);
        }
    }
}