package E_3_1_1;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        ST<String, Float> st = new ST<String, Float>();
        st.put("A+", 4.33f);
        st.put("A", 4f);
        st.put("A-", 3.67f);
        st.put("B+", 3.33f);
        st.put("B", 3f);
        st.put("B-", 2.67f);
        st.put("C+", 2.33f);
        st.put("C", 2.00f);
        st.put("C-", 1.67f);
        st.put("D", 1f);
        st.put("F", 0f);

        float total = 0;
        int count = 0;

        while (!StdIn.isEmpty()) {
            String gradeLetter = StdIn.readString();
            Float gradeNum = st.get(gradeLetter);
            if (gradeNum != null) {
                total += gradeNum;
                count++;
            } else {
                StdOut.println("Letter grade " + gradeLetter + " does not exist.");
            }
        }

        StdOut.println("Average is -> " + total / count);
    }
}