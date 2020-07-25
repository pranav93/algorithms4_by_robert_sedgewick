package SymbolGraph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        String filename = args[0];
        String delim = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delim);

        Graph G = sg.G();
        StdOut.println("Done processing input");
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            if (sg.contains(source)) {
                for (int v : G.adj(sg.index(source))) {
                    StdOut.println("\t" + sg.name(v));
                }
            }
        }
    }
}