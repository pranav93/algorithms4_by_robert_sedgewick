package DepthFirstPaths;

import Graph.Graph;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		this.marked = new boolean[G.V()];
		this.edgeTo = new int[G.V()];
		this.dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		this.marked[v] = true;
		for (int i : G.adj(v)) {
			if (!this.marked[i]) {
				this.edgeTo[i] = v;
				this.dfs(G, i);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return this.marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!this.hasPathTo(v)) {
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();
		for (int i = v; i != this.s; i = this.edgeTo[i]) {
			path.push(i);
		}
		path.push(s);
		return path;
	}

}