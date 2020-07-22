package E_3_5_10;

import edu.princeton.cs.algs4.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node {
        Key key;
        Queue<Value> value;
        int N;
        Node left, right;
        boolean color;

        Node(Key key, Value value, int N) {
            this.key = key;
            this.value = new Queue<Value>();
            this.value.enqueue(value);
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
            node.value.enqueue(value);
            node.N++;
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
        node.N = 1 + this.size(node.left) + this.size(node.right);
        return this.fixup(node);
    }

    public Value get(Key key) {
        Node node = this.get(this.root, key);
        if (node == null) {
            return null;
        }
        return node.value.peek();
    }

    public Iterable<Value> getAll(Key key) {
        Node node = this.get(this.root, key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return this.get(node.left, key);
        } else if (cmp > 0) {
            return this.get(node.right, key);
        } else {
            return node;
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        this.keys(this.root, q, null, null);
        return q;
    }

    public Iterable<Key> keys(Key min, Key max) {
        Queue<Key> q = new Queue<Key>();
        this.keys(this.root, q, min, max);
        return q;
    }

    private void keys(Node node, Queue<Key> q, Key min, Key max) {
        if (node == null) {
            return;
        }
        int cmp1, cmp2;
        this.keys(node.left, q, min, max);
        if (min == null && max == null) {
            q.enqueue(node.key);
        } else {
            cmp1 = node.key.compareTo(min);
            cmp2 = node.key.compareTo(max);
            if (cmp1 >= 0 && cmp2 <= 0) {
                q.enqueue(node.key);
            }
        }
        this.keys(node.right, q, min, max);
    }

    public boolean contains(Key key) {
        return this.contains(this.root, key);
    }

    private boolean contains(Node node, Key key) {
        if (node == null) {
            return false;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return this.contains(node.left, key);
        } else if (cmp > 0) {
            return this.contains(node.right, key);
        } else {
            return true;
        }
    }

}