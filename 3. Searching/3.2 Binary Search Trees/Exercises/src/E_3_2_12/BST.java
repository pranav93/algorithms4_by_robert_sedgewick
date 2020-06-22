package E_3_2_12;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    class Node {
        Key key;
        Value value;
        Node left;
        Node right;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    Node root;

    public void put(Key key, Value value) {
        this.root = this.put(this.root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) { return new Node(key, value); }

        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            node.value = value;
        else if (cmp < 0)
            node.left = this.put(node.left, key, value);
        else
            node.right = this.put(node.right, key, value);

        return node;
    }

    public Value get(Key key) {
        Node n = this.get(this.root, key);
        if (n == null) return null;
        return n.value;
    }

    private Node get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        else if (cmp < 0)
            return this.get(node.left, key);
        else
            return this.get(node.right, key);
    }

    public Key min() {
        if (this.root == null) return null;
        Node n = this.min(this.root);
        return n.key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return this.min(node.left);
    }

    public Key max() {
        if (this.root == null) return null;
        Node n = this.max(this.root);
        return n.key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return this.max(node.right);
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

        if (key.compareTo(minNode.key) < 0) return node;
        return this.floor(node.right, key);
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

        if (key.compareTo(maxNode.key) > 0) return node;
        return this.ceiling(node.left, key);
    }

    public void deleteMin() {
        if (this.root == null) return;
        this.root = this.deleteMin(this.root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = this.deleteMin(node.left);
        return node;
    }

    public void deleteMax() {
        if (this.root == null) return;
        this.root = this.deleteMax(this.root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) return node.left;
        node.right = this.deleteMax(node.right);
        return node;
    }

    public void delete(Key key) {
        this.root = this.delete(this.root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = this.delete(node.left, key);
        else if (cmp > 0)
            node.right = this.delete(node.right, key);
        else {
            if (node.left == null && node.right == null)
                return null;
            else if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                Node succNode = this.min(node.right);
                succNode.right = this.deleteMin(node.right);
                succNode.left = node.left;
                node = succNode;
            }
        }
        return node;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        this.keys(this.root, q);
        return q;
    }

    private void keys(Node node, Queue<Key> q) {
        if (node == null) return;
        this.keys(node.left, q);
        q.enqueue(node.key);
        this.keys(node.right, q);
    }

    public int size() {
        return this.size(this.root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return this.size(node.left) + 1 + this.size(node.right);
    }
}