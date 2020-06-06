package E_2_5_2;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class StrComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

}

public class Client {
    // Same length compound words are not recognised
    public static void main(String[] args) {
        String[] a = StdIn.readStrings();
        findCompound(a);
    }

    private static void findCompound(String[] a) {

        StdOut.println(Arrays.toString(a));
        StrComparator sc = new StrComparator();
        QuickSort.sort(a, sc);
        // StdOut.println(Arrays.toString(a));

        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                String s1 = a[i];
                String s2 = a[j];
                int s3Length = s1.length() + s2.length();
                findElement(a, s3Length, s1, s2);
            }
        }
    }

    private static void findElement(String[] a, int s3Length, String s1, String s2) {
        int index = BinarySearch.search(a, s3Length);
        if (index != -1) {
            if (s1.concat(s2).compareTo(a[index]) == 0 || s2.concat(s1).compareTo(a[index]) == 0) {
                StdOut.println("Compound string is -> " + a[index]);
            }
        }
    }
}