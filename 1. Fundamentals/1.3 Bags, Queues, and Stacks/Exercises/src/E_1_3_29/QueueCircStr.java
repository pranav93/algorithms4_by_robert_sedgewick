package E_1_3_29;

public class QueueCircStr {
    class Node {
        String item;
        Node next;
    }

    Node last;
    int N;

    public void enque(String item) {
        Node temp = new Node();
        temp.item = item;
        if (this.last == null) {
            this.last = temp;
            this.last.next = this.last;
        } else {
            temp.next = this.last.next;
            this.last.next = temp;
            this.last = this.last.next;
        }
        this.N++;
    }

    public String deque() {
        Node temp = this.last.next;
        if (this.last.next == this.last) {
            this.last = null;
        } else {
            this.last.next = this.last.next.next;
        }
        temp.next = null;
        this.N--;
        return temp.item;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }
}