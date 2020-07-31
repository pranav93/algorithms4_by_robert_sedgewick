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
        int diameter = gp.diameter();
        int radius = gp.radius();
        int center = gp.center();

        StdOut.println("===================================================");
        StdOut.println("diameter -> " + diameter);
        StdOut.println("radius -> " + radius);
        StdOut.println("center -> " + center);
        // int bIndex = SG.index("Bacon, Kevin");
        // StdOut.println("Kevin Bacon eccentricity -> " +
        // cc.eccentricity(largestCompId, bIndex));
        // StdOut.println("Diameter of compId " + largestCompId + " -> " +
        // cc.diameter(largestCompId));
        // StdOut.println("Radius of compId " + largestCompId + " -> " +
        // cc.radius(largestCompId));
        // StdOut.println("Center of compId " + largestCompId + " -> " +
        // cc.center(largestCompId));

        // int chosenCompId = 0;
        // StdOut.println("Diameter of compId " + chosenCompId + " -> " +
        // cc.diameter(chosenCompId));
        // StdOut.println("Radius of compId " + chosenCompId + " -> " +
        // cc.radius(chosenCompId));
        // StdOut.println("Center of compId " + chosenCompId + " -> " +
        // cc.center(chosenCompId));
    }
}