package SymbolGraph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream, String sp) {
        this.st = new ST<String, Integer>();
        In in = new In(stream);

        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    this.st.put(a[i], st.size());
                }
            }
        }
        this.keys = new String[st.size()];
        for (String key : this.st.keys()) {
            this.keys[st.get(key)] = key;
        }
        this.G = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = this.st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return this.st.contains(s);
    }

    public Integer index(String s) {
        return this.st.get(s);
    }

    public String name(int v) {
        return this.keys[v];
    }

    public Graph G() {
        return this.G;
    }
}