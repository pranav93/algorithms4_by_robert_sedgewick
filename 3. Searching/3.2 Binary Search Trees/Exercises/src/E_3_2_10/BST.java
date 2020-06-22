package E_3_2_10;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int N;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.N = 1;
        }
    }

    Node root;

    public void put(Key key, Value value) {
        this.root = this.put(this.root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = this.put(node.left, key, value);
        } else {
            node.right = this.put(node.right, key, value);
        }
        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    public Value get(Key key) {
        Node n = this.get(this.root, key);
        if (n == null) return null;
        return n.value;
    }

    private Node get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return this.get(node.left, key);
        } else {
            return this.get(node.right, key);
        }
    }

    public Key min() {
        if (this.root == null) return null;
        Node n = this.min(this.root);
        return n.key;
    }

    private Node min(Node node) {
        if (node.left == null) { return node; }
        return this.min(node.left);
    }

    public Key max() {
        if (this.root == null) return null;
        Node n = this.max(this.root);
        return n.key;
    }

    private Node max(Node node) {
        if (node.right == null) { return node; }
        return this.max(node.right);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        this.keys(this.root, q);
        return q;
    }

    private void keys(Node node, Queue<Key> q) {
        if (node == null) { return; }
        this.keys(node.left, q);
        q.enqueue(node.key);
        this.keys(node.right, q);
    }

    public Key floor(Key key) {
        Node n = this.floor(this.root, key);
        if (n == null) return null;
        return n.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp < 0) return this.floor(node.left, key);

        if (node.right == null) return node;
        Node minNode = this.min(node.right);
        if (minNode.key.compareTo(key) <= 0) {
            return this.floor(node.right, key);
        } else {
            return node;
        }
    }

    public Key ceiling(Key key) {
        Node n = this.ceiling(this.root, key);
        if (n == null) return null;
        return n.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp > 0) return this.ceiling(node.right, key);

        if (node.left == null) return node;
        Node maxNode = this.max(node.left);
        if (maxNode.key.compareTo(key) < 0) {
            return node;
        } else {
            return this.ceiling(node.left, key);
        }
    }

    public Key select(int k) {
        Node n = this.select(this.root, k);
        if (n == null) { return null; }
        return n.key;
    }

    private Node select(Node node, int k) {
        if (node == null) return null;
        int t = size(node.left);
        if (t == k) { return node; }
        if (k < t) return this.select(node.left, k);
        k = k - 1 - t;
        return this.select(node.right, k);
    }

    public int rank(Key key) {
        return this.rank(this.root, key, 0);
    }

    private int rank(Node node, Key key, int k) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return this.rank(node.left, key, k);

        int t = size(node.left);
        k = k + 1 + t;
        if (cmp == 0) return k;
        return this.rank(node.right, key, k);
    }

    public int size() {
        return this.size(this.root);
    }
}