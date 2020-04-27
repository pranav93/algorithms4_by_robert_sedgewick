package E_1_3_8;

public class DoublingStackOfStrings {
    String[] arr = new String[1];
    int N;

    private static String[] resize(String[] ar, int newSize) {
        String[] temp = new String[newSize];
        for (int i = 0; i < ar.length; i++) {
            temp[i] = ar[i];
        }
        return temp;
    }

    public void push(String item) {
        this.arr[this.N] = item;
        this.N++;
        if (N == this.arr.length) {
            this.arr = resize(this.arr, 2 * this.N);
        }

    }

    public String pop() {
        return this.arr[--this.N];
    }

    public int size() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int arrSize() {
        return this.arr.length;
    }

    public String[] arrContent() {
        return this.arr;
    }
}