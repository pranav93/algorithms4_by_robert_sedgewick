package ArrayRepresentation.Stack;

import java.util.Iterator;

public class Stack<Key> implements Iterable<Key> {
    private Key[] arr;
    private int size;

    public Stack(int max) {
        this.arr = (Key[]) new Object[max];
    }

    public void push(Key k) {
        this.arr[this.size++] = k;
    }

    public Key pop() {
        return this.arr[--this.size];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }

    class StackIterator implements Iterator<Key> {
        int i = size;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return i > 0;
        }

        @Override
        public Key next() {
            // TODO Auto-generated method stub
            Key k = arr[--i];
            return k;
        }
    }
}