package E_4_1_18;

public class FindGirth {
    private int girth;
    private Iterable<Integer> girthPath;

    FindGirth(Graph G) {
        this.girth = Integer.MAX_VALUE;
        for (int i = 0; i < G.V(); i++) {
            FindSmallestCycle fsc = new FindSmallestCycle(G, i);
            if (fsc.cycleSize() < girth) {
                this.girth = fsc.cycleSize();
                this.girthPath = fsc.path();
            }
        }
    }

    public int girth() {
        return this.girth;
    }

    public Iterable<Integer> girthPath() {
        return this.girthPath;
    }
}