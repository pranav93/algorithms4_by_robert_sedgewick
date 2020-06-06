package E_2_5_2;

public class BinarySearch {
    public static int search(String[] arr, int length) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = lo + (hi - lo) / 2;
        while (lo <= hi) {
            if (arr[mid].length() < length) {
                lo = mid + 1;
            } else if (arr[mid].length() > length) {
                hi = mid - 1;
            } else {
                return mid;
            }
            mid = lo + (hi - lo) / 2;
        }
        return -1;
    }
}