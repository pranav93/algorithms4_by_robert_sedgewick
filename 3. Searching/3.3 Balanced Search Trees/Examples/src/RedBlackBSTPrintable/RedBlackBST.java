package RedBlackBSTPrintable;

import PrintTree.TreePrinter;
import PrintTree.TreePrinter.PrintableNode;
import edu.princeton.cs.algs4.StdOut;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node implements PrintableNode {
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
            if (this.color == RED) {
                return (String) this.key + " (RED)";
            } else {
                return (String) this.key;
            }
        }
    }

    Node root;

    public void put(Key key, Value value, boolean print) {
        this.root = this.put(this.root, key, value, print);
        if (this.root.color == RED) {
            this.root.color = BLACK;
        }
    }

    private Node put(Node node, Key key, Value value, boolean print) {
        if (node == null) {
            if (print) {
                StdOut.println("Created node with key " + key + " and value " + value);
            }
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = this.put(node.left, key, value, print);
        } else if (cmp > 0) {
            node.right = this.put(node.right, key, value, print);
        } else {
            if (print) {
                StdOut.println("Updated value of key " + key + " to value " + value);
            }
            node.value = value;
        }

        if (this.isRed(node.right) && !this.isRed(node.left)) {
            if (print) {
                StdOut.println("Rotating tree with key " + node.key + " at it's root to left");
            }
            node = this.rotateLeft(node, print);
            if (print) {
                StdOut.println("Rotating left done");
            }
        }
        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            if (print) {
                StdOut.println("Rotating tree with key " + node.key + " at it's root to right");
            }
            node = this.rotateRight(node, print);
            if (print) {
                StdOut.println("Rotating right done");
            }
        }
        if (this.isRed(node.left) && this.isRed(node.right)) {
            if (print) {
                StdOut.println("Flipping colors for tree with key " + node.key + " at it's root");
            }
            this.flipColors(node, print);
            if (print) {
                StdOut.println("Color flipping done");
            }
        }

        node.N = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    private void flipColors(Node h, boolean print) {
        if (print) {
            TreePrinter.print(h);
        }
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
        if (print) {
            TreePrinter.print(h);
        }
    }

    private Node rotateRight(Node h, boolean print) {
        if (print) {
            TreePrinter.print(h);
        }
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.N = this.size(h);
        h.N = 1 + this.size(h.left) + this.size(h.right);
        x.color = h.color;
        h.color = RED;
        if (print) {
            TreePrinter.print(x);
        }
        return x;
    }

    private Node rotateLeft(Node h, boolean print) {
        if (print) {
            TreePrinter.print(h);
        }
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.N = this.size(h);
        h.N = 1 + this.size(h.left) + this.size(h.right);
        x.color = h.color;
        h.color = RED;
        if (print) {
            TreePrinter.print(x);
        }
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

    public void deleteMin(boolean print) {
        this.root = this.deleteMin(this.root, print);
        if (this.isRed(this.root)) {
            this.root.color = BLACK;
        }
    }

    private Node deleteMin(Node node, boolean print) {
        if (node.left == null) {
            return null;
        }

        if (!this.isRed(node.left) && !this.isRed(node.left.left)) {
            StdOut.println("Child and grandchild of node with key " + node.key + " are black");
            StdOut.println("Moving red to left");
            node = this.moveRedLeft(node, print);
        }

        node.left = this.deleteMin(node.left, print);
        node = this.fixup(node, print);
        return node;
    }

    private Node fixup(Node node, boolean print) {
        if (this.isRed(node.right) && !this.isRed(node.left)) {
            node = this.rotateLeft(node, print);
        }
        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            node = this.rotateLeft(node.right, print);
        }
        if (this.isRed(node.left) && this.isRed(node.right)) {
            this.flipColors(node, print);
        }
        return node;
    }

    private Node moveRedLeft(Node node, boolean print) {
        if (print) {
            StdOut.println("Inside moveRedLeft. Flipping colors");
        }
        this.flipColors(node, print);
        if (print) {
            StdOut.println("Flipping colors done");
        }
        TreePrinter.print(node);
        if (this.isRed(node.right.left)) {
            if (print) {
                StdOut.println("node with key " + node.key + " has two consecutive red children on right");
            }
            node.right = this.rotateRight(node.right, print);
            node = this.rotateLeft(node, print);
            this.flipColors(node, print);
            TreePrinter.print(node);
        }
        return node;
    }
}