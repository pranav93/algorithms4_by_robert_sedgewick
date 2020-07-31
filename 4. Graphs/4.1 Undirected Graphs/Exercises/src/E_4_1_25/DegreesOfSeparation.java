package E_4_1_25;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1], Integer.parseInt(args[3]));
        Graph G = sg.G();

        String source = args[2];
        if (!sg.contains(source)) {
            StdOut.println(source + " is not in database.");
            return;
        }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        while (StdIn.hasNextLine()) {
            String sink = StdIn.readLine();
            if (!sg.contains(sink)) {
                StdOut.println(sink + " is not in database.");
                continue;
            }
            int t = sg.index(sink);
            if (bfs.hasPathTo(t)) {
                for (int p : bfs.pathTo(t)) {
                    StdOut.println("\t" + sg.name(p));
                }
            } else {
                StdOut.println(sink + " is not connected to " + source);
            }
        }
    }
}