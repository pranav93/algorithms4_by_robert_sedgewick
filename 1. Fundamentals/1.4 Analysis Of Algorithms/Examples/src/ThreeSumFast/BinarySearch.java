package ThreeSumFast;

import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
    public static int rank(int[] arr, int val) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] < val) {
                lo = mid + 1;
            } else if(arr[mid] > val) {
                hi = mid - 1;
            } else {
                // arr[mid] == val
                return mid;
            }
        }
        return -1;
    }
}