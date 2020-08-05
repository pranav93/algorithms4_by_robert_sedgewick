package SymbolDigraph;

import Digraph.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolDigraph {
    private Digraph G;
    private String[] keys;
    private ST<String, Integer> st;

    public SymbolDigraph(String filename, String sep) {
        this.st = new ST<String, Integer>();
        In in = new In(filename);

        while (in.hasNextLine()) {
            String[] strArr = in.readLine().split(sep);
            for (String key : strArr) {
                if (!this.st.contains(key)) {
                    this.st.put(key, this.st.size());
                }
            }
        }

        this.keys = new String[this.st.size()];
        for (String key : st.keys()) {
            this.keys[this.st.get(key)] = key;
        }

        this.G = new Digraph(this.st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] strArr = in.readLine().split(sep);
            int v = this.st.get(strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                this.G.addEdge(v, this.st.get(strArr[i]));
            }
        }
    }

    public Digraph G() {
        return this.G;
    }

    public int index(String s) {
        return this.st.get(s);
    }

    public String name(int v) {
        return this.keys[v];
    }
}