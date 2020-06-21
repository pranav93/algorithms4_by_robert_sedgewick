package E_3_2_8;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

public class BST<Key extends Comparable<Key>, Value> {
    class Node {
        Key key;
        Value value;
        int N;
        int H;
        Node left;
        Node right;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            N = 1;
            H = 0;
        }
    }

    Node root;

    public Value get(Key key) {
        Node node = this.get(this.root, key);
        if (node == null) return null;
        return node.value;
    }

    private Node get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return this.get(node.right, key);
        } else {
            return this.get(node.left, key);
        }
    }

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
        node.N = 1 + this.size(node.left) + size(node.right);
        node.H = 1 + this.max(this.height(node.left), this.height(node.right));
        return node;
    }

    private int max(int height1, int height2) {
        if (height1 < height2)
            return height2;
        else
            return height1;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.H;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    public int size() {
        return this.size(this.root);
    }

    public int height() {
        return this.height(this.root);
    }

    public int height(Key key) {
        Node node = this.get(this.root, key);
        return this.height(node);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        this.keys(this.root, q);
        return q;
    }

    private void keys(Node node, Queue<Key> q) {
        if (node == null) {
            return;
        }
        this.keys(node.left, q);
        q.enqueue(node.key);
        this.keys(node.right, q);
    }

    public float optCompares(int N) {
        int compareSum = 0;
        Key[] keys = (Key[]) new Comparable[this.size()];
        int i = 0;
        for (Key k : this.keys()) {
            keys[i++] = k;
        }
        for (int j = 0; j < N; j++) {
            Key randKey = keys[StdRandom.uniform(0, this.size())];
            compareSum += this.compares(randKey);
        }
        return ((float) compareSum / N) + 1;
    }

    private int compares(Key k) {
        return this.compares(this.root, k);
    }

    private int compares(Node node, Key k) {
        if (node == null) {
            return 0;
        }
        int cmp = k.compareTo(node.key);
        if (cmp == 0) {
            return 1;
        } else if (cmp < 0) {
            return 1 + this.compares(node.left, k);
        } else {
            return 1 + this.compares(node.right, k);
        }
    }
}