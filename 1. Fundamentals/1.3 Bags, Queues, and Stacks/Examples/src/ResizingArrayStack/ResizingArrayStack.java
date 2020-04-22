package ResizingArrayStack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private int N;
    private Item[] a;

    public ResizingArrayStack() {
        this.a = (Item[]) new Object[1];
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < this.N; i++) {
            temp[i] = this.a[i];
        }
        this.a = temp;
    }

    public void push(Item item) {
        if (this.N == this.a.length) {
            resize(2 * this.a.length);
        }
        this.a[N++] = item;
    }

    public Item pop() {
        Item item = this.a[--N];
        this.a[N] = null;
        if (this.N > 0 && this.N == this.a.length / 4) {
            resize(this.a.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return i > 0;
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            return a[--i];
        }
    }

}