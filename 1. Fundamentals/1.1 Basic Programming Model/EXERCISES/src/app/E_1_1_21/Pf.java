package app.E_1_1_21;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
1.1.21 Write a program that reads in lines from standard input with each line containing
a name and two integers and then uses printf() to print a table with a column of
the names, the integers, and the result of dividing the first by the second, accurate to
three decimal places. You could use a program like this to tabulate batting averages for
baseball players or grades for students.
*/

public class Pf {
    public static void main(String[] args) {
        String line;
        while (!StdIn.isEmpty()) {
            line = StdIn.readLine();
            String[] lineArr = line.split(" ");
            double int1 = Double.parseDouble(lineArr[1]);
            double int2 = Double.parseDouble(lineArr[2]);
            double com = int1 / int2;
            StdOut.printf("%s\t%.3f\n", line, com);
        }
    }
}