package app.E_1_2_4;

import edu.princeton.cs.algs4.StdOut;

public class CircMatch {
    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];

        if (s1.length() != s2.length()) {
            StdOut.printf("( %s ) is not circular match of ( %s )\n", s1, s2);
            return;
        }

        if (s1.equals(s2)) {
            StdOut.printf("( %s ) is circular match of ( %s )\n", s1, s2);
            printCircular(s1, s2, 0);
            return;
        }

        int len = s1.length();
        int subIndex = -1;
        int subIndexlo = 0;
        int subIndexhi = 1;
        boolean matchFound = false;
        int fromIndex = 0;
        int fromIndexNext = 0;

        while (subIndexlo < subIndexhi) {
            subIndex = s2.indexOf(s1.substring(subIndexlo, subIndexhi), fromIndex);
            if (subIndex != -1) {
                fromIndexNext = subIndex + 1;
                if ((len - subIndex) == (subIndexhi - subIndexlo)) {
                    matchFound = true;
                    break;
                }
                subIndexhi++;
            } else {
                subIndexhi--;
                fromIndex = fromIndexNext;
            }
        }

        StdOut.printf("s1 -> %s\n", s1);
        StdOut.printf("s1 -> %s\n", s2);
        StdOut.printf("subString -> %s\n", s1.substring(subIndexlo, subIndexhi));
        StdOut.printf("matchFound -> %b\n", matchFound);
        StdOut.printf("subIndex -> %d\n", subIndex);

        if (!matchFound) {
            StdOut.printf("( %s ) is not circular match of ( %s )\n", s1, s2);
            return;
        }

        if (s1.substring(subIndexhi).equals(s2.substring(0, subIndex))) {
            StdOut.printf("( %s ) is circular match of ( %s )\n", s1, s2);
            printCircular(s1, s2, subIndex);
            return;
        }

        StdOut.printf("( %s ) is not circular match of ( %s )\n", s1, s2);
    }

    public static void printCircular(String s1, String s2, int subIndex) {
        for (int i = 0; i < subIndex; i++) {
            StdOut.printf("%s\t", ".");
        }
        for (int i = 0; i < s1.length(); i++) {
            StdOut.printf("%s\t", s1.charAt(i));
        }
        StdOut.println();
        for (int i = 0; i < s2.length(); i++) {
            StdOut.printf("%s\t", s2.charAt(i));
        }
        for (int i = 0; i < subIndex; i++) {
            StdOut.printf("%s\t", ".");
        }
        StdOut.println();
    }
}