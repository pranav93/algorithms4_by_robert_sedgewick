package E_1_3_15;

public class QueueStr {
    class Node {
        String item;
        Node next;
        Node prev;
    }

    Node first;
    Node last;
    int N;

    public void enque(String item) {
        Node temp = new Node();
        temp.item = item;
        if (this.isEmpty()) {
            this.first = temp;
            this.last = temp;
        } else {
            this.last.next = temp;
            temp.prev = this.last;
            this.last = temp;
        }
        this.N++;
    }

    public String deque() {
        Node temp = this.first;
        this.first = this.first.next;
        String item = temp.item;
        temp = null;
        this.N--;
        return item;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }
}