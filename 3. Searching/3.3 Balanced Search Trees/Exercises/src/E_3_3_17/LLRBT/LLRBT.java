package E_3_3_17.LLRBT;

import E_3_3_17.PrintTree.TreePrinter;
import E_3_3_17.PrintTree.TreePrinter.PrintableNode;

public class LLRBT<Key extends Comparable<Key>, Value> {
    static boolean RED = true;
    static boolean BLACK = false;

    class Node implements PrintableNode {
        Key key;
        Value value;
        Node left, right;
        boolean color;
        int N;

        Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
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
            }
            return (String) this.key;
        }
    }

    Node root;

    public void put(Key key, Value value) {
        this.root = this.put(this.root, key, value);
        if (this.isRed(this.root)) {
            this.root.color = BLACK;
        }
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, RED);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = this.put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = this.put(node.right, key, value);
        } else {
            node.value = value;
        }

        if (this.isRed(node.right) && !this.isRed(node.left)) {
            node = this.rotateLeft(node);
        }
        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            node = this.rotateRight(node);
        }
        if (this.isRed(node.right) && this.isRed(node.left)) {
            this.flipColors(node);
        }

        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    private void flipColors(Node node) {
        if (node != null) {
            node.color = !node.color;
            if (node.left != null) {
                node.left.color = !node.left.color;
            }
            if (node.right != null) {
                node.right.color = !node.right.color;
            }
        }
    }

    private Node rotateLeft(Node h) {
        // adjust links
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        // change colors
        boolean tempColor = x.color;
        x.color = h.color;
        h.color = tempColor;
        // adjust sub-tree size
        x.N = h.N;
        h.N = 1 + this.size(h.left) + this.size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        // adjust links
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        // change colors
        boolean tempColor = x.color;
        x.color = h.color;
        h.color = tempColor;
        // adjust sub-tree size
        x.N = h.N;
        h.N = 1 + this.size(h.left) + this.size(h.right);
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

    public void print() {
        TreePrinter.print(this.root);
    }
}