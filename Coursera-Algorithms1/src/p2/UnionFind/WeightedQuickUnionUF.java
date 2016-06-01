package p2.UnionFind;


/*  1. The objects for which connectivity is to be find are integers in this implementation.
 *  2. The integers(objects) are indices of array.
 *  3. The connectivity is established by manipulating the values at the indices.
 */

public class WeightedQuickUnionUF {

	
	private int[] id;
	private int[] size;
	
	WeightedQuickUnionUF(int N){
		id = new int[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
			size[i] = 1;  // Initially size is 1 as each element is root of itself.
		}
	}
	
	
	/* The criteria for the root is id[i] == i.
	 * Initially all the elements are roots of themselves.
	 */
	private int root(int p){
		
		while(id[p] != p) p = id[p];
		return p;
	}
	
	/* Two objects are connected if they have same root
	 * The above is the condition for Quick Union
	 */
	public boolean find(int p, int q){
		return root(p) == root(q);
	}
	
	/* This method connects two objects.
	 * The algorithm used is weighted Quick Union
	 * The idea is to generate a balanced tree so that the number of iterations to find root are less
	 */
	
	public void union(int p, int q){
		int rootP = root(p); // this can be p or something else
		int rootQ = root(q); 
		
		if(rootP == rootQ) return;
		// id[rootP] = rootQ;  Without considering the sizes of the trees
		
		if(size[rootP] < size[rootQ]){
			id[rootP] = rootQ;
			size[rootQ] +=  size[rootP];
		}
		else {
			id[rootQ] = rootP;
			size[rootP] +=  size[rootQ];
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
