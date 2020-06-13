package E_3_1_12;

public class Node<Key extends Comparable<Key>, Value> implements Comparable<Node<Key, Value>> {
    Key key;
    Value value;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Node<Key, Value> that) {
        return this.key.compareTo(that.key);
    }

    @Override
    public String toString() {
        return "[ (" + this.key + ") -> (" + this.value + ") ]";
    }

}