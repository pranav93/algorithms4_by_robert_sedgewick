package BST;

public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left, right;
        int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

    }

    private Node root;

    public void put(Key key, Value value) {
        this.root = this.put(this.root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.N = 1 + size(node.left) + size(node.right);
        return node;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    public Value get(Key key) {
        return this.get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return this.get(node.left, key);
        } else if (cmp > 0) {
            return this.get(node.right, key);
        } else {
            return node.value;
        }
    }

    public int size() {
        return this.size(this.root);
    }

    public Key min() {
        if (this.root == null) return null;
        return this.min(this.root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return this.min(node.left);
    }

    public Key max() {
        if (this.root == null) return null;
        return this.max(this.root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return this.max(node.right);
    }

    public Key floor(Key key) {
        Node node = this.floor(this.root, key);
        if (node == null) return null;
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp < 0) return this.floor(node.left, key);
        Node rightFloor = this.floor(node.right, key);
        if (rightFloor == null) return node;
        return rightFloor;
    }

    public Key ceiling(Key key) {
        Node node = this.ceiling(this.root, key);
        if (node == null) return null;
        return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp > 0) return this.ceiling(node.right, key);
        Node leftCeiling = this.ceiling(node.left, key);
        if (leftCeiling == null) return node;
        return leftCeiling;
    }

    public Key select(int k) {
        Node node = this.select(this.root, k);
        if (node == null) return null;
        return node.key;
    }

    private Node select(Node node, int k) {
        if (node == null) return null;
        int t = size(node.left);
        if (t == k) return node;
        if (t > k) return this.select(node.left, k);
        return this.select(node.right, k - t - 1);
    }

    public int rank(Key key) {
        return this.rank(this.root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return this.size(node.left);
        if (cmp < 0) return this.rank(node.left, key);
        return this.size(node.left) + 1 + this.rank(node.right, key);
    }

    public void deleteMin() {
        if (this.root == null) return;
        this.root = this.deleteMin(this.root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = this.deleteMin(node.left);
        node.N = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void deleteMax() {
        if (this.root == null) return;
        this.root = this.deleteMax(this.root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.N = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void delete(Key key) {
        this.root = this.deleteSuccNode(this.root, key);
    }

    private Node deleteSuccNode(Node node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = this.deleteSuccNode(node.left, key);
        } else if (cmp > 0) {
            node.right = this.deleteSuccNode(node.right, key);
        } else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node succNode = this.min(node.right);
            succNode.right = this.deleteMin(node.right);
            succNode.left = node.left;
            node.left = null;
            node.right = null;
            node = succNode;
        }
        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }
}