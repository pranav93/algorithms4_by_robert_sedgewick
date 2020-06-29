package RedBlackBSTPrintable;

import PrintTree.TreePrinter;
import PrintTree.TreePrinter.PrintableNode;
import edu.princeton.cs.algs4.StdOut;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node implements PrintableNode {
        Key key;
        Value value;
        int N;
        Node left, right;
        boolean color;

        Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = 1;
            this.color = RED;
        }

        @Override
        public PrintableNode getLeft() {
            return this.left;
        }

        @Override
        public PrintableNode getRight() {
            return this.right;
        }

        @Override
        public String getText() {
            if (this.color == RED) {
                return (String) this.key + " (RED)";
            } else {
                return (String) this.key;
            }
        }
    }

    Node root;

    public void put(Key key, Value value) {
        this.root = this.put(this.root, key, value);
        if (this.root.color == RED) {
            this.root.color = BLACK;
        }
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            StdOut.println("Created node with key " + key + " and value " + value);
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = this.put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = this.put(node.right, key, value);
        } else {
            StdOut.println("Updated value of key " + key + " to value " + value);
            node.value = value;
        }

        if (this.isRed(node.right) && !this.isRed(node.left)) {
            StdOut.println("Rotating tree with key " + node.key + " at it's root to left");
            node = this.rotateLeft(node);
            StdOut.println("Rotating left done");
        }
        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            StdOut.println("Rotating tree with key " + node.key + " at it's root to right");
            node = this.rotateRight(node);
            StdOut.println("Rotating right done");
        }
        if (this.isRed(node.left) && this.isRed(node.right)) {
            StdOut.println("Flipping colors for tree with key " + node.key + " at it's root");
            this.flipColors(node);
            StdOut.println("Color flipping done");
        }

        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    private void flipColors(Node h) {
        TreePrinter.print(h);
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
        TreePrinter.print(h);
    }

    private Node rotateRight(Node h) {
        TreePrinter.print(h);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.N = this.size(h);
        h.N = 1 + this.size(h.left) + this.size(h.right);
        x.color = h.color;
        h.color = RED;
        TreePrinter.print(x);
        return x;
    }

    private Node rotateLeft(Node h) {
        TreePrinter.print(h);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.N = this.size(h);
        h.N = 1 + this.size(h.left) + this.size(h.right);
        x.color = h.color;
        h.color = RED;
        TreePrinter.print(x);
        return x;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color;
    }

    public void deleteMin() {
        this.root = this.deleteMin(this.root);
        if (this.isRed(this.root)) {
            this.root.color = BLACK;
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return null;
        }

        if (!this.isRed(node.left) && !this.isRed(node.left.left)) {
            node = this.moveRedLeft(node);
        }

        node.left = this.deleteMin(node.left);
        this.fixup(node);
        return node;
    }

    private void fixup(Node node) {
        if (this.isRed(node.right) && !this.isRed(node.left)) {
            this.rotateLeft(node);
        }
        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            this.rotateLeft(node.right);
        }
        if (this.isRed(node.left) && this.isRed(node.right)) {
            this.flipColors(node);
        }
    }

    private Node moveRedLeft(Node node) {
        this.flipColors(node);
        if (this.isRed(node.right) && this.isRed(node.right.left)) {
            node.right = this.rotateRight(node.right);
            node = this.rotateLeft(node);
            this.flipColors(node);
        }
        return node;
    }
}