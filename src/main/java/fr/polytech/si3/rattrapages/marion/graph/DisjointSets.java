package fr.polytech.si3.rattrapages.marion.graph;

/**
 * A class to handle disjoint sets
 */
public class DisjointSets {

	// FAther or siZE: if faze[i] >= 0, faze[i] is the father of i in the up-tree
	// else i is the root of the up-tree and -father[i] is the size of the up-tree
	private int faze[];
	
	// the current number of subsets
	private int numSets;
	
	/**
	 * builds a disjoint set system of size n with
	 * the n initial single-element sets
	 * {0}, {1}, {2}, ..., {n-1}
	 */
	public DisjointSets(int n) {
		faze = new int [n];
		for (int i = 0; i < faze.length; i++) {
			faze[i] = -1;
		}
		numSets = n;
	}
	
	/**
	 * returns the current number of
	 * subsets in the disjoint set system
	 */
	public int numSets() {
		return numSets;
	}
	
	/**
	 * returns the root of the
	 * up-tree containing i doing
	 * path compression
	 */
	public int find(int i) {
		if (faze[i] < 0) {
			return i;
		}
		else {
			faze[i] = find(faze[i]);
			return faze[i];
		}
	}
	
	/**
	 * performs the union of the two subsets
	 * of roots root1 and root2
	 */
	public void union(int root1, int root2) {
		numSets--;
		if (faze[root1] <= faze[root2]) {
			faze[root1] += faze[root2];
			faze[root2] = root1;
		}
		else {
			faze[root2] += faze[root1];
			faze[root1] = root2;
		}
	}

}
