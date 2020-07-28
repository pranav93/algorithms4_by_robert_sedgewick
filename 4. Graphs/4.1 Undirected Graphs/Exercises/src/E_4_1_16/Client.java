package E_4_1_16;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        StdOut.println(G);

        GraphProperties gp = new GraphProperties(G);

        for (int i = 0; i < G.V(); i++) {
            StdOut.println("eccentricity of " + i + " -> " + gp.eccentricity(i));
        }
        StdOut.println("------------------------");
        StdOut.println("diameter of G -> " + gp.diameter());
        StdOut.println("------------------------");
        StdOut.println("radius of G -> " + gp.radius());
        StdOut.println("------------------------");
        StdOut.println("center of G -> " + gp.center());
        StdOut.println("------------------------");
    }
}