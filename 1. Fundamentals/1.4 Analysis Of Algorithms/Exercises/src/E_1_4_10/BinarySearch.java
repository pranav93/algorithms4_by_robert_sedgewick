package E_1_4_10;

public class BinarySearch {
    public static int rank(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int mid;
        int lastMidIndex = -1;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;                
            } else {
                lastMidIndex = mid;
                hi = mid - 1;
            }
        }

        return lastMidIndex;
    }
}