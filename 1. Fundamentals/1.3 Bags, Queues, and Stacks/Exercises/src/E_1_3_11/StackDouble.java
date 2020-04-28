package E_1_3_11;

public class StackDouble {
    class Node {
        double item;
        Node next;
    };

    Node first;
    int N;

    public void push(double item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = this.first;
        this.first = temp;
        this.N++;
    }

    public double pop() {
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