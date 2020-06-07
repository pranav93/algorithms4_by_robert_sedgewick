package E_2_5_9;

import java.util.Comparator;

public class AmountComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }

}