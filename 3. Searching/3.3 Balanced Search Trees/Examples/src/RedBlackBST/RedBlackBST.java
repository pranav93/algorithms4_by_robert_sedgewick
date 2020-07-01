package RedBlackBST;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node {
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
            return new Node(key, value, 1);
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
        if (this.isRed(node.left) && this.isRed(node.right)) {
            this.flipColors(node);
        }

        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    private void flipColors(Node h) {
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
        h.color = !h.color;
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

    public Key min() {
        Node minNode = this.min(this.root);
        if (minNode == null) {
            return null;
        }
        return minNode.key;
    }

    private Node min(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return this.min(node.left);
    }

    public void deleteMin() {
        this.root = this.deleteMin(this.root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return null;
        }

        if (!this.isRed(node.left) && !this.isRed(node.left.left)) {
            node = this.moveRedLeft(node);
        }

        node.left = this.deleteMin(node.left);
        node = this.fixup(node);
        return node;
    }

    private Node fixup(Node node) {
        if (this.isRed(node.right) && !this.isRed(node.left)) {
            node = this.rotateLeft(node);
        }
        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            node = this.rotateRight(node);
        }
        if (this.isRed(node.left) && this.isRed(node.right)) {
            this.flipColors(node);
        }
        return node;
    }

    private Node moveRedLeft(Node node) {
        this.flipColors(node);

        if (this.isRed(node.right.left)) {
            node.right = this.rotateRight(node.right);
            node = this.rotateLeft(node);
            this.flipColors(node);
        }

        return node;
    }

    public Key max() {
        Node maxNode = this.max(this.root);
        if (maxNode == null) {
            return null;
        }
        return maxNode.key;
    }

    private Node max(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return this.max(node.right);
    }

    public void deleteMax() {
        this.root = this.deleteMax(this.root);
    }

    private Node deleteMax(Node node) {
        if (this.isRed(node.left)) {
            node = this.rotateRight(node);
        }

        if (node.right == null) {
            return node.left;
        }

        if (!this.isRed(node.right) && !this.isRed(node.right.left)) {
            node = this.moveRedRight(node);
        }

        node.right = this.deleteMax(node.right);
        node = this.fixup(node);
        return node;
    }

    private Node moveRedRight(Node node) {
        this.flipColors(node);
        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            node = this.rotateRight(node);
            this.flipColors(node);
        }
        return node;
    }
}