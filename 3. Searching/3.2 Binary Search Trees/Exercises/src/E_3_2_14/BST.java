package E_3_2_14;

import edu.princeton.cs.algs4.Stack;

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

    public Value get(Key key) {
        Node node = this.root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0)
                return node.value;
            else if (cmp < 0)
                node = node.left;
            else
                node = node.right;
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (this.root == null) {
            this.root = new Node(key, value);
            return;
        }

        Node node = this.root;
        Stack<Node> stackNode = new Stack<Node>();
        while (true) {
            stackNode.push(node);
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                node.value = value;
                return;
            } else if (cmp < 0) {
                if (node.left == null) {
                    node.left = new Node(key, value);
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new Node(key, value);
                    break;
                }
                node = node.right;
            }
        }

        while (stackNode.isEmpty()) {
            Node n = stackNode.pop();
            n.N = 1 + this.size(n.right) + this.size(n.left);
        }
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    public Key min() {
        Node n = this.min(this.root);
        if (n == null) return null;
        return n.key;
    }

    private Node min(Node node) {
        if (node == null) return null;
        while (true) {
            if (node.left == null) return node;
            node = node.left;
        }
    }

    public Key max() {
        Node n = this.max(this.root);
        if (n == null) return null;
        return n.key;
    }

    private Node max(Node node) {
        if (node == null) return null;
        while (true) {
            if (node.right == null) return node;
            node = node.right;
        }
    }

    public Key floor(Key key) {
        Node node = this.root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return node.key;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                if (node.right == null) return node.key;
                Node minNode = this.min(node.right);
                if (minNode.key.compareTo(key) <= 0) {
                    node = node.right;
                } else {
                    return node.key;
                }
            }
        }
        return null;
    }

    public Key ceiling(Key key) {
        Node node = this.root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return node.key;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                if (node.left == null) return node.key;
                Node maxNode = this.max(node.left);
                if (key.compareTo(maxNode.key) <= 0) {
                    node = node.left;
                } else {
                    return node.key;
                }
            }
        }
        return null;
    }
}