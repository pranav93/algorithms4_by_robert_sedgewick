package app;

public class Counter {
    private final String name;
    private int count;

    public Counter(String id) {
        this.name = id;
    }

    public void increment() {
        this.count++;
    }

    public int tally() {
        return this.count;
    }

    public String toString() {
        return this.count + " " + this.name;
    }
}