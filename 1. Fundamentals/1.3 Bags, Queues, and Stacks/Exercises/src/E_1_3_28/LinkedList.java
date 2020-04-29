package E_1_3_28;

import edu.princeton.cs.algs4.StdOut;

public class LinkedList {
    class Node {
        int item;
        Node next;
    }

    Node first;
    int N;

    public void insertFirst(int item) {
        Node temp = new Node();
        temp.item = item;
        temp.next = this.first;
        this.first = temp;
        this.N++;
    }

    public int removeLast() {
        Node current = this.first;
        while (current.next.next != null) {
            current = current.next;
        }
        Node prev = current;
        current = current.next;
        int item = current.item;
        prev.next = null;
        this.N--;
        return item;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void listContent() {
        Node current = this.first;
        StdOut.printf("First -> \t");
        while (current != null) {
            StdOut.printf("Node [ %s ] -> \t", current.item);
            current = current.next;
        }
        StdOut.printf("NULL\n");
    }

    public int delete(int k) {
        Node current = this.first;
        while (k != 1) {
            current = current.next;
            k--;
        }
        Node prev = current;
        current = current.next;
        int item = current.item;
        prev.next = current.next;
        this.N--;
        return item;
    }

    public boolean contains(int key) {
        Node current = this.first;
        while (current != null) {
            if (current.item == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean removeAfter(int key) {
        Node current = this.first;
        while (current != null && current.item != key) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return false;
        }
        Node target = current.next;
        current.next = target.next;
        this.N--;
        return true;
    }

    public boolean insertAfter(int key, int val) {
        Node current = this.first;
        while (current != null && current.item != key) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        Node temp = new Node();
        temp.item = val;
        temp.next = current.next;
        current.next = temp;
        this.N++;
        return true;
    }

    public void remove(int key) {
        Node current = this.first;
        Node prev = null;
        while (current != null) {
            if (current.item == key) {
                if (prev == null) {
                    this.first = current.next;
                } else {
                    prev.next = current.next;
                }
                this.N--;
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    public int max(Node node) {
        if (node == null) {
            return 0;
        }
        int nextMax = this.max(node.next);
        if (nextMax > node.item) {
            return nextMax;
        } else {
            return node.item;
        }
    }

    public int max() {
        return max(this.first);
    }
}