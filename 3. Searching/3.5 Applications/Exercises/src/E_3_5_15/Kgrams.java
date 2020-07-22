package E_3_5_15;

import E_3_5_10.RedBlackBST;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Kgrams {
    public static void main(String[] args) {
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        String inp = StdIn.readLine();

        int sepCount = 0;
        int sz = Integer.parseInt(args[0]);

        int i = 0;
        Queue<Integer> qStart = new Queue<Integer>();
        int start = 0;
        qStart.enqueue(0);
        for (i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == ' ' || inp.charAt(i) == '\n') {
                sepCount++;
                qStart.enqueue(i + 1);
                if (sepCount == sz) {
                    start = qStart.dequeue();
                    st.put(inp.substring(start, i), start);
                    sepCount--;
                }
            }
        }
        if (i > 0) {
            start = qStart.dequeue();
            st.put(inp.substring(start, i), start);
        }

        for (String string : st.keys()) {
            StdOut.println(string + " -> " + st.getAll(string));
        }
    }
}