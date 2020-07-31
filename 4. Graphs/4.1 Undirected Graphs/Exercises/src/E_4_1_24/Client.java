package E_4_1_24;

import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        SymbolGraph SG = new SymbolGraph(args[0], args[1]);
        Graph G = SG.G();
        ConnectedComponents cc = new ConnectedComponents(G);

        StdOut.println("cc count -> " + cc.count());
        int compless10 = 0;
        int largestCompId = 0;
        int largestCompSize = -1;

        for (int i = 0; i < cc.count(); i++) {
            int compSize = cc.componentSize(i);
            StdOut.println("Comp id -> " + i + " size -> " + compSize);
            if (compSize < 10) {
                compless10++;
            }
            if (compSize > largestCompSize) {
                largestCompSize = compSize;
                largestCompId = i;
            }
        }
        StdOut.println();
        StdOut.println("Number of components less than 10 -> " + compless10);
        StdOut.println("Largest component's id is -> " + largestCompId);
        StdOut.println("Largest component's size is -> " + largestCompSize);

        // Check if kavin bacon is in largest component
        StdOut.println();
        if (cc.checkVertexInComponent(SG.index("Bacon, Kevin"), largestCompId)) {
            StdOut.println("Kevin Bacon is in the largest component");
        } else {
            StdOut.println("Kevin Bacon is not in the largest component");
        }

        StdOut.println();

        GraphProperties gp = new GraphProperties(cc, 0);
        int[] props = gp.props();
        StdOut.println("diameter -> " + props[1]);
        StdOut.println("radius -> " + props[0]);
        StdOut.println("center -> " + props[2]);

        FindSmallestCycle fsc = new FindSmallestCycle(G, SG.index("Bacon, Kevin"));
        StdOut.println("Girth -> " + fsc.cycleSize());
    }
}