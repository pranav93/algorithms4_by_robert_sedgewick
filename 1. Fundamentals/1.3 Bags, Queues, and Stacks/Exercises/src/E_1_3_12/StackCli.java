package E_1_3_12;

import E_1_3_9.StackStr;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackCli {
    public static void main(String[] args) {
        StackStr st = new StackStr();

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            st.push(input);
        }

        st.stackContents();
        StackStr st2 = stCopy(st);
        StdOut.println("st2");
        st2.stackContents();
    }

    public static StackStr stCopy(StackStr st) {
        StackStr st2 = new StackStr();
        StackStr temp = new StackStr();

        for (String item : st) {
            temp.push(item);
        }
        for (String item : temp) {
            st2.push(item);
        }

        return st2;
    }
}