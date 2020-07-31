package E_4_1_24;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
    ST<String, Integer> st = new ST<String, Integer>();
    String[] keys;
    Graph G;

    SymbolGraph(String stream, String sep) {
        In in = new In(stream);
        while (in.hasNextLine()) {
            String[] strArr = in.readLine().split(sep);
            for (int i = 0; i < strArr.length; i++) {
                if (!st.contains(strArr[i])) {
                    st.put(strArr[i], st.size());
                }
            }
        }

        this.keys = new String[st.size()];
        for (String key : this.st.keys()) {
            this.keys[this.st.get(key)] = key;
        }

        this.G = new Graph(st.size());

        in = new In(stream);
        while (in.hasNextLine()) {
            String[] strArr = in.readLine().split(sep);
            int v = this.st.get(strArr[0]);
            for (int i = 0; i < strArr.length; i++) {
                this.G.addEdge(v, this.st.get(strArr[i]));
            }
        }
    }

    public boolean contains(String key) {
        return this.st.contains(key);
    }

    public int index(String key) {
        return this.st.get(key);
    }

    public String name(int v) {
        return this.keys[v];
    }

    public Graph G() {
        return this.G;
    }

}