package E_4_1_22;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        SymbolGraph SG = new SymbolGraph(args[0], args[1]);
        Graph G = SG.G();
        BreadthFirstSearch bfs = new BreadthFirstSearch(G, SG.index("Bacon, Kevin"));
        StdOut.println("Done processing");

        while (!StdIn.isEmpty()) {
            String query = StdIn.readLine();
            if (!SG.contains(query)) {
                StdOut.println(query + " is not in database");
                continue;
            }
            Iterable<Integer> it = bfs.pathTo(SG.index(query));
            if (it == null) {
                StdOut.println(query + " is not related with 'Kevin Bacon'");
                continue;
            }
            for (int i : it) {
                StdOut.println("\t" + SG.name(i));
            }
            StdOut.println();
        }
    }
}