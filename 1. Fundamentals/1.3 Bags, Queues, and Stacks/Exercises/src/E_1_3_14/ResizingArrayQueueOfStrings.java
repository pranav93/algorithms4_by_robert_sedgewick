package E_1_3_14;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings {
    String[] arr = new String[1];
    int size = 1;
    int first = 0;
    int last = 0;
    int qSize = 0;

    public void enque(String item) {
        this.arr[this.last++] = item;
        this.qSize++;
        if (this.last == this.size) {
            this.last = 0;
        }
        if (this.last == this.first) {
            resize(this.size * 2);
        } else {
            // last < first
            // do nothing
            this.debugQ();
        }
    }

    private void resize(int newSize) {
        String[] temp = new String[newSize];

        for (int i = 0; i < this.qSize; i++) {
            temp[i] = this.arr[(i + this.first) % this.size];
        }

        this.arr = temp;
        this.first = 0;
        this.last = this.qSize;
        this.size = newSize;
        this.debugQ();
    }

    public String deque() {
        if (this.isEmpty()) {
            throw new IllegalAccessError("Queue is empty");
        }
        String item = this.arr[this.first++];
        this.qSize--;
        if (this.qSize == (this.size / 4)) {
            this.resize(this.size / 2);
        }
        this.debugQ();
        return item;
    }

    public boolean isEmpty() {
        return this.qSize == 0;
    }

    public boolean isFull() {
        return this.qSize == (this.size - 1);
    }

    private void debugQ() {
        StdOut.println("first -> " + this.first);
        StdOut.println("last -> " + this.last);
        StdOut.println("size -> " + this.size);
        StdOut.println("arr -> " + Arrays.toString(this.arr));
    }
}