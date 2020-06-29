package TopDown234Trees;

public class BST234<Key extends Comparable<Key>, Value> {
    private static boolean RED = true;
    private static boolean BLACK = false;

    class Node {
        Key key;
        Value value;
        int N;
        Node left, right;
        boolean color;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.N = 1;
            this.color = RED;
        }
    }

    Node root;

    public void put(Key key, Value value) {
        this.root = this.put(this.root, key, value);
        if (this.isRed(this.root)) {
            this.root.color = BLACK;
        }
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (this.isRed(node.right) && this.isRed(node.left)) {
            this.flipColors(node);
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

        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.N = this.size(h);
        h.N = 1 + this.size(h.left) + this.size(h.right);
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.N = this.size(h);
        h.N = 1 + this.size(h.left) + this.size(h.right);
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private int size(Node h) {
        if (h == null) {
            return 0;
        }
        return h.N;
    }
}