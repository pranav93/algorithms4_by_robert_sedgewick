package E_3_5_9;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    class Node {
        Key key;
        Value value;
        Node left, right;
        int N;

        public Node(Key key, Value value) {
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
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp <= 0) {
            node.left = this.put(node.left, key, value);
        } else {
            node.right = this.put(node.right, key, value);
        }
        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    public Value get(Key key) {
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

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    public void delete(Key key) {
        this.root = this.delete(this.root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = this.delete(node.left, key);
        } else if (cmp > 0) {
            node.right = this.delete(node.right, key);
        } else {
            // find max in left subtree and make it root
            // Using collection for multiple values reduces implementation complexity
            if (node.left != null) {
                Node maxNode = this.findMax(node.left);
                maxNode.left = this.deleteMax(node.left);
                maxNode.right = node.right;
                node = maxNode;
                node = this.delete(node, key);
            } else {
                node = node.right;
            }
        }
        if (node != null) {
            node.N = 1 + this.size(node.left) + this.size(node.right);
        }
        return node;
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return null;
        }
        node.right = this.findMax(node.right);
        return node;
    }

    private Node findMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return this.findMax(node.right);
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
}