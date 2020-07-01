package LLRedBlackBSTPrintable;

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
        if (this.root == null) {
            return;
        }
        this.root = this.deleteMin(this.root, print);
        if (this.isRed(this.root)) {
            this.root.color = BLACK;
        }
    }

    public void deleteMax(boolean print) {
        if (this.root == null) {
            return;
        }
        this.root = this.deleteMax(this.root, print);
        if (this.isRed(this.root)) {
            this.root.color = BLACK;
        }
    }

    private Node deleteMax(Node node, boolean print) {
        if (this.isRed(node.left)) {
            if (print) {
                StdOut.println("----");
                StdOut.println("Left child of node with key " + node.key + " is red");
                StdOut.println("Rotating red to right");
            }
            node = this.rotateRight(node, print);
            if (print) {
                StdOut.println("Now entire tree is");
                TreePrinter.print(root);
                StdOut.println("----");
            }
        }

        if (node.right == null) {
            StdOut.println("Deleted " + node.key);
            return node.left;
        }

        if (!this.isRed(node.right) && !this.isRed(node.right.left)) {
            if (print) {
                StdOut.println("----");
                StdOut.println("Child and grandchild [right] of node with key " + node.key + " are black");
                StdOut.println("Moving red to right");
            }
            node = this.moveRedRight(node, print);
            if (print) {
                StdOut.println("Now entire tree is");
                TreePrinter.print(root);
                StdOut.println("----");
            }
        }

        node.right = this.deleteMax(node.right, print);
        if (print) {
            StdOut.println("----");
            StdOut.println("Fixing up tree with key " + node.key + " at root");
        }
        node = this.fixup(node, print);
        if (print) {
            StdOut.println("Fixing up done, node is yet to be returned to callee");
            StdOut.println("Now entire tree looks like");
            TreePrinter.print(root);
            StdOut.println("----");
        }
        return node;
    }

    private Node moveRedRight(Node node, boolean print) {
        if (print) {
            StdOut.println("Inside moveRedRight. Flipping colors");
        }
        this.flipColors(node, print);
        if (print) {
            StdOut.println("Flipping colors done");
            TreePrinter.print(node);
        }
        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            if (print) {
                StdOut.println("node with key " + node.key + " has two consecutive red children on left");
            }
            node = this.rotateRight(node, print);
            this.flipColors(node, print);
            if (print) {
                TreePrinter.print(node);
            }
        }
        return node;
    }

    private Node deleteMin(Node node, boolean print) {
        if (node.left == null) {
            StdOut.print("Deleted " + node.key);
            return node.right;
        }

        if (!this.isRed(node.left) && !this.isRed(node.left.left)) {
            if (print) {
                StdOut.println("----");
                StdOut.println("Child and grandchild of node with key " + node.key + " are black");
                StdOut.println("Moving red to left");
            }
            node = this.moveRedLeft(node, print);
            if (print) {
                StdOut.println("Now entire tree is");
                TreePrinter.print(root);
                StdOut.println("----");
            }
        }

        node.left = this.deleteMin(node.left, print);
        if (print) {
            StdOut.println("----");
            StdOut.println("Fixing up tree with key " + node.key + " at root");
        }
        node = this.fixup(node, print);
        if (print) {
            StdOut.println("Fixing up done, node is yet to be returned to callee");
            StdOut.println("Now entire tree looks like");
            TreePrinter.print(root);
            StdOut.println("----");
        }
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
            TreePrinter.print(node);
        }
        if (this.isRed(node.right.left)) {
            if (print) {
                StdOut.println("node with key " + node.key + " has two consecutive red children on right");
            }
            node.right = this.rotateRight(node.right, print);
            node = this.rotateLeft(node, print);
            this.flipColors(node, print);
            if (print) {
                TreePrinter.print(node);
            }
        }
        return node;
    }

    public void delete(Key key) {
        this.root = this.delete(this.root, key);
        if (this.isRed(this.root)) {
            this.root.color = BLACK;
        }
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return node;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            if (!this.isRed(node.left) && !this.isRed(node.left.left)) {
                node = this.moveRedLeft(node, false);
            }
            node.left = this.delete(node.left, key);
        } else if (cmp > 0) {
            if (this.isRed(node.left)) {
                node = this.rotateRight(node, false);
            }
            if (!this.isRed(node.right) && !this.isRed(node.right.left)) {
                node = this.moveRedRight(node, false);
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
                node.right = this.deleteMin(node.right, false);
            }
        }

        return this.fixup(node, false);
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

}
