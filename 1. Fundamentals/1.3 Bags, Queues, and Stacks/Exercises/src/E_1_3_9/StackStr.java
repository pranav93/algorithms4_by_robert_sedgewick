package E_1_3_9;

public class StackStr {
    class Node {
        String item;
        Node next;
    }

    private Node first;
    private int N;

    public void push(String item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = this.first;
        this.first = temp;
        this.N++;
    }

    public String pop() {
        Node temp = this.first;
        this.first = this.first.next;
        temp.next = null;
        this.N--;
        return temp.item;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }
}