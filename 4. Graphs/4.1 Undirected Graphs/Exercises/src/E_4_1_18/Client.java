package E_4_1_18;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        StdOut.println(G);

        FindGirth fg = new FindGirth(G);
        StdOut.println("girth -> " + fg.girth());
        StdOut.println("girthPath -> " + fg.girthPath());
    }
}