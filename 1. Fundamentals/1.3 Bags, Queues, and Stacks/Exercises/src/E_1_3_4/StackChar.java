package E_1_3_4;

public class StackChar {
    private class Node {
        char item;
        Node next;
    }

    private int N;
    private Node first;

    public void push(char s) {
        Node temp = new Node();
        temp.item = s;
        temp.next = this.first;
        this.first = temp;
        this.N++;
    }

    public char pop() {
        Node temp = this.first;
        this.first = temp.next;
        temp.next = null;
        this.N--;
        return temp.item;
    }

    public char top() {
        return this.first.item;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }
}