package union.find;

import java.util.Arrays;

public class WeightedQuickUnionUF {

	private int[] id;
	private int[] size;
	
	WeightedQuickUnionUF(int N){
		id = new int[N];
		size = new int[N];
		for(int i = 0;i < N;i++){
			id[i] = i;
			size[i] = 1;
		}
	}
	
	// point root of p to q -- first element will be changed
	public void union(int p, int q){
		int rootP = root(p);
		int rootQ = root(q);
		
		if(rootP == rootQ) return;
		// Calculate height of tree and then link the root of smaller tree to root of larger tree
		
		if(size[rootP] < size[rootQ]) {
			id[rootP] = rootQ;
			size[rootQ] = size[rootQ] + size[rootP];
		}
		else {
			id[rootQ] = rootP;
			size[rootP] = size[rootQ] + size[rootP];
		}
	}
	
	public boolean connected (int p, int q){
		return (root(id[p]) == root(id[q]));
	}
	
	/*public int root(int p){
		while(p != id[p]){
			p = id[p];
		}
		return p;
	}*/
	
	// to compress the tree further i.e. flatten the tree --WQUPC weighted quik union with path compression
			public int root(int p){
				while(p != id[p]){
					id[p] = id[id[p]];
					p = id[p];
				}
				return p;
			}
	
	
	public String toString(){
		return Arrays.toString(id);
	}
}
