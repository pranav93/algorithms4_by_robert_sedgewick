package E_3_5_3;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchSET<Key extends Comparable<Key>> {
    class Node {
        Key key;
        Node left, right;
        int N;

        public Node(Key key) {
            this.key = key;
            this.N = 1;
        }

    }

    Node root;

    public void add(Key key) {
        this.root = this.add(this.root, key);
    }

    private Node add(Node node, Key key) {
        if (node == null) {
            return new Node(key);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = this.add(node.left, key);
        } else if (cmp > 0) {
            node.right = this.add(node.right, key);
        }
        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
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

    public int size() {
        return this.size(this.root);
    }

    public boolean isEmpty() {
        return this.size() == 0;
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

    public void remove(Key key) {
        this.root = this.remove(this.root, key);
    }

    private Node remove(Node node, Key key) {
        if (node == null) {
            return node;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = this.remove(node.left, key);
        } else if (cmp > 0) {
            node.right = this.remove(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            Node minNode = this.findMin(node.right);
            minNode.right = this.deleteMin(node.right);
            minNode.left = node.left;
            node = minNode;
        }
        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = this.deleteMin(node.left);
        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return this.findMin(node.left);
    }
}