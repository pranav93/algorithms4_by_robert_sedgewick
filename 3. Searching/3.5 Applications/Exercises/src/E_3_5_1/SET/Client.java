package E_3_5_1.SET;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String[] strArr = "S E A R C H E X A M P L E".split(" ");
        SET<String> set = new SET<String>();

        for (int i = 0; i < strArr.length; i++) {
            set.add(strArr[i]);
        }

        for (String string : set.keys()) {
            StdOut.print("\t" + string);
        }
        StdOut.println();
    }
}