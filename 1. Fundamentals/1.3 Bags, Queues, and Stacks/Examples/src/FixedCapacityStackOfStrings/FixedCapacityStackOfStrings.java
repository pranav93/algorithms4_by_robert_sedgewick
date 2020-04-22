package FixedCapacityStackOfStrings;

public class FixedCapacityStackOfStrings {
    private int N;
    private String[] a;

    FixedCapacityStackOfStrings(int cap) {
        this.a = new String[cap];
    }

    public void push(String item) {
        this.a[N++] = item;
    }

    public String pop() {
        return this.a[--N];
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }
}