package E_4_1_26;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];
        if (!sg.contains(source)) {
            StdOut.println(source + " is not in database.");
            return;
        }
        int s = sg.index(source);
        DepthFirstPaths dfs = new DepthFirstPaths(G, s, sg);
        StdOut.println("Done processing");

        while (StdIn.hasNextLine()) {
            String sink = StdIn.readLine();
            if (!sg.contains(sink)) {
                StdOut.println(sink + " is not in database.");
                continue;
            }
            int t = sg.index(sink);
            if (dfs.hasPathTo(t)) {
                int c = 0;
                for (int p : dfs.pathTo(t)) {
                    StdOut.println("\t" + sg.name(p));
                    c++;
                }
                StdOut.println(c);
            } else {
                StdOut.println(sink + " is not connected to " + source);
            }
        }
    }
}