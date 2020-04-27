package E_1_3_1;

import java.util.Iterator;

public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] StrArr;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        this.N = 0;
        this.StrArr = new String[cap];
    }

    public void push(String item) {
        this.StrArr[this.N++] = item;
    }

    public String pop() {
        return this.StrArr[--this.N];
    }

    public int size() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public boolean isFull() {
        return this.N == this.StrArr.length;
    }

    @Override
    public Iterator<String> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }

    class StackIterator implements Iterator {
        private int current = N;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current > 0;
        }

        @Override
        public String next() {
            // TODO Auto-generated method stub
            String item = StrArr[--current];
            return item;
        }

    }

}