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
        if (node == null) {
            return new Node(key, value, 1);
        }
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
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    public Value get(Key key) {
        return this.get(root, key);
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

    public int size() {
        return this.size(this.root);
    }

    public Key min() {
        return this.min(this.root);
    }

    private Key min(Node node) {
        if (node.left == null) {
            return node.key;
        }
        return this.min(node.left);
    }

    public Key max() {
        return this.max(this.root);
    }

    private Key max(Node node) {
        if (node.right == null) {
            return node.key;
        }
        return this.max(node.right);
    }

    public Key floor(Key key) {
        Node node = this.floor(this.root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return this.floor(node.left, key);
        } else if (cmp > 0) {
            Node rightFloor = this.floor(node.right, key);
            if (rightFloor == null) {
                return node;
            } else {
                return rightFloor;
            }
        } else {
            return node;
        }
    }
}