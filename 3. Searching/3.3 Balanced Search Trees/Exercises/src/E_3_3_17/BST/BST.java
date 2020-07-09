package E_3_3_17.BST;

import E_3_3_17.PrintTree.TreePrinter.PrintableNode;
import E_3_3_17.PrintTree.TreePrinter;

public class BST<Key extends Comparable<Key>, Value> {
    class Node implements PrintableNode {
        Key key;
        Value value;
        Node left, right;
        int N;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.N = 1;
        }

        @Override
        public PrintableNode getLeft() {
            return this.left;
        }

        @Override
        public PrintableNode getRight() {
            return this.right;
        }

        @Override
        public String getText() {
            return (String) this.key;
        }
    }

    Node root;

    public void print() {
        TreePrinter.print(this.root);
    }

    public void put(Key key, Value value) {
        this.root = this.put(this.root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = this.put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = this.put(node.right, key, value);
        } else {
            node.value = value;
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
}