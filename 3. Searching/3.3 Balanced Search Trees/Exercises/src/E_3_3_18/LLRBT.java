package E_3_3_18;

import edu.princeton.cs.algs4.Queue;

public class LLRBT<Key extends Comparable<Key>, Value> {

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

    public void delete(Key key) {
        this.root = this.delete(this.root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return node;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            if (!this.isRed(node.left) && !this.isRed(node.left.left)) {
                node = this.moveRedLeft(node);
            }
            node.left = this.delete(node.left, key);
        } else if (cmp > 0) {
            if (this.isRed(node.left)) {
                node = this.rotateRight(node);
            }
            if (!this.isRed(node.right) && !this.isRed(node.right.left)) {
                node = this.moveRedRight(node);
            }
            node.right = this.delete(node.right, key);
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
                node.value = minNode.value;
                node.right = this.deleteMin(node.right);
            }
        }

        return this.fixup(node);
    }

    public int size() {
        if (this.root == null) {
            return 0;
        }
        return this.root.N;
    }

    public Iterable<Key> keys() {
        Queue<Key> qKeys = new Queue<Key>();
        this.keys(this.root, qKeys);
        return qKeys;
    }

    private void keys(Node node, Queue<Key> qKeys) {
        if (node == null) {
            return;
        }
        this.keys(node.left, qKeys);
        qKeys.enqueue(node.key);
        this.keys(node.right, qKeys);
    }

    public Key floor(Key key) {
        return this.floor(this.root, key);
    }

    private Key floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return this.floor(node.left, key);
        }
        if (cmp == 0) {
            return key;
        }
        if (node.right == null) {
            return node.key;
        }
        Node minNode = this.min(node.right);
        int cmpMin = minNode.key.compareTo(key);
        if (cmpMin <= 0) {
            return this.floor(node.right, key);
        }
        return node.key;
    }

    public Value get(Key key) {
        return this.get(this.root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return this.get(node.left, key);
        } else if (cmp > 0) {
            return this.get(node.right, key);
        } else {
            return node.value;
        }
    }

    public Key ceiling(Key key) {
        return this.ceiling(this.root, key);
    }

    private Key ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return this.ceiling(node.right, key);
        }
        if (cmp == 0) {
            return node.key;
        }
        if (node.left == null) {
            return node.key;
        }
        Node maxNode = this.max(node.left);
        int cmpMax = maxNode.key.compareTo(key);
        if (cmpMax >= 0) {
            return this.ceiling(node.left, key);
        }
        return node.key;
    }

}