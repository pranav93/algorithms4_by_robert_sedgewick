package E_3_1_12;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Node<String, String>[] strArr = (Node<String, String>[]) new Node[5];
        strArr[0] = new Node<String, String>("Martial", "ST");
        strArr[1] = new Node<String, String>("Rashford", "LW");
        strArr[2] = new Node<String, String>("James", "RW");
        strArr[3] = new Node<String, String>("Pogba", "LM");
        strArr[4] = new Node<String, String>("Fernandes", "RM");

        BinarySearchST<String, String> st = new BinarySearchST<String, String>(strArr);
        StdOut.println("Size -> " + st.size());
        StdOut.println("--------------------------------------");

        StdOut.println("Rashford -> " + st.get("Rashford"));
        StdOut.println("Martial -> " + st.get("Martial"));
        StdOut.println("Pogba -> " + st.get("Pogba"));
        StdOut.println("DeGea -> " + st.get("DeGea"));
        StdOut.println("Inserting DeGea");
        st.put("DeGea", "GK");
        StdOut.println("Inserting DeGea");
        st.put("DeGea", "GK");
        StdOut.println("Inserting Shaw");
        st.put("Shaw", "LB");
        StdOut.println("Inserting WanBissaka");
        st.put("WanBissaka", "RB");
        StdOut.println("Inserting WanBissaka");
        st.put("WanBissaka", "RB");
        StdOut.println("Inserting Maguire");
        st.put("Maguire", "CB");
        StdOut.println("Inserting Lindelof");
        st.put("Lindelof", "CB");
        StdOut.println("DeGea -> " + st.get("DeGea"));
        StdOut.println("--------------------------------------");

        StdOut.println("Printing all players");
        for (String key : st.keys()) {
            StdOut.println(key);
        }
        StdOut.println("--------------------------------------");

        StdOut.println("Deleting all players");
        StdOut.println("Size -> " + st.size());
        for (String key : st.keys()) {
            StdOut.println("Deleting " + key);
            st.delete(key);
            StdOut.println("Size -> " + st.size());
        }
    }
}