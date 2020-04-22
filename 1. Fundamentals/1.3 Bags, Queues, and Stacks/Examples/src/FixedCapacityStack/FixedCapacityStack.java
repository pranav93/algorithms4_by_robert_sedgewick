package FixedCapacityStack;

public class FixedCapacityStack<Item> {
    private int N;
    private Item[] a;

    FixedCapacityStack(int cap) {
        this.a = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        this.a[this.N++] = item;
    }

    public Item pop() {
        return this.a[--this.N];
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }
}