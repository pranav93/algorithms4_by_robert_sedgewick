package E_4_1_23;

import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        SymbolGraph SG = new SymbolGraph(args[0], args[1]);
        Graph G = SG.G();
        Histogram h = new Histogram(G, SG.index("Bacon, Kevin"));
        StdOut.println("Done processing");

        // ST<Integer, SET<Integer>> histogram = h.histogram();
        // StdOut.println(histogram.get(0));
        ST<Integer, Integer> histogramCountSt = h.histogramCount();
        for (int key : histogramCountSt) {
            StdOut.println("Bacon number -> " + key + " count -> " + histogramCountSt.get(key));
        }
    }
}