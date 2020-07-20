package E_3_5_7.SETdouble;

import edu.princeton.cs.algs4.Queue;

public class SETdouble {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node {
        double key;
        int N;
        Node left, right;
        boolean color;

        Node(double key, int N) {
            this.key = key;
            this.N = 1;
            this.color = RED;
        }
    }

    Node root;

    public void add(double key) {
        this.root = this.add(this.root, key);
        if (this.root.color == RED) {
            this.root.color = BLACK;
        }
    }

    private Node add(Node node, double key) {
        if (node == null) {
            return new Node(key, 1);
        }

        double cmp = key - node.key;

        if (cmp < 0) {
            node.left = this.add(node.left, key);
        } else if (cmp > 0) {
            node.right = this.add(node.right, key);
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
        if (h != null) {
            h.color = !h.color;
        } else {
            return;
        }
        if (h.left != null) {
            h.left.color = !h.left.color;
        }
        if (h.right != null) {
            h.right.color = !h.right.color;
        }
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

    public double min() {
        Node minNode = this.min(this.root);
        if (minNode == null) {
            return 0;
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

    public double max() {
        Node maxNode = this.max(this.root);
        if (maxNode == null) {
            return 0;
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

    public void remove(double key) {
        this.root = this.remove(this.root, key);
    }

    private Node remove(Node node, double key) {
        if (node == null) {
            return node;
        }

        double cmp = key - node.key;
        if (cmp < 0) {
            if (!this.isRed(node.left) && node.left != null && !this.isRed(node.left.left)) {
                node = this.moveRedLeft(node);
            }
            node.left = this.remove(node.left, key);
        } else if (cmp > 0) {
            if (this.isRed(node.left)) {
                node = this.rotateRight(node);
            }
            if (!this.isRed(node.right) && node.right != null && !this.isRed(node.right.left)) {
                node = this.moveRedRight(node);
            }
            node.right = this.remove(node.right, key);
        } else {
            if (node.right == null && node.left == null) {
                return null;
            } else if (node.right == null && node.left != null) {
                Node nodeToDelete = node;
                node = node.left;
                node.color = nodeToDelete.color;
            } else {
                Node minNode = this.min(node.right);
                node.key = minNode.key;
                node.right = this.deleteMin(node.right);
            }
        }
        node.N = 1 + this.size(node.left) + this.size(node.right);
        return this.fixup(node);
    }

    public Iterable<Double> keys() {
        Queue<Double> q = new Queue<Double>();
        this.keys(this.root, q);
        return q;
    }

    private void keys(Node node, Queue<Double> q) {
        if (node == null) {
            return;
        }
        this.keys(node.left, q);
        q.enqueue(node.key);
        this.keys(node.right, q);
    }

    public boolean contains(double key) {
        return this.contains(this.root, key);
    }

    private boolean contains(Node node, double key) {
        if (node == null) {
            return false;
        }
        double cmp = key - node.key;
        if (cmp < 0) {
            return this.contains(node.left, key);
        } else if (cmp > 0) {
            return this.contains(node.right, key);
        } else {
            return true;
        }
    }

    public int size() {
        return this.size(this.root);
    }
}