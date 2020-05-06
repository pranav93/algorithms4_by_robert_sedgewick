package E_1_4_8;

public class BinarySearch {
    public static int rank(int[] a, int lo, int key) {
        int hi = a.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] < key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid - 1;                
            } else {
                return mid;
            }
        }

        return -1;
    }
}