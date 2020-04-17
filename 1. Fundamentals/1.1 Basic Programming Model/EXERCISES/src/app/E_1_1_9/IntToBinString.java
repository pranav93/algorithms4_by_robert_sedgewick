package app.E_1_1_9;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.1.9 Write a code fragment that puts the binary representation of a positive integer N
into a String s.
Solution: Java has a built-in method Integer.toBinaryString(N) for this job, but
the point of the exercise is to see how such a method might be implemented. Here is a
particularly concise solution:
String s = "";
for (int n = N; n > 0; n /= 2)
s = (n % 2) + s;
1.1 ■ Basic Programming Model 55
*/

public class IntToBinString {
    public static void main(String[] args) {
        int myNum = StdIn.readInt();
        int x;
        String finalNum = "";

        while (myNum > 0) {
            x = myNum % 2;
            myNum = myNum / 2;
            finalNum = x + finalNum;
        }

        StdOut.printf("%s\n", finalNum);
    }
}