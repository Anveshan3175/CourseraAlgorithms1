package p2.UnionFind;

public class QuickUnionUF {

	// underlying data structure
	private int[] id;
	
	// initializing UF for quick union implementation
	QuickUnionUF(int N){
		id = new int[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}
	
	
	//chase the parent until root is reached
	private int root(int i){
		/*if(id[i] == i) return i;
		return root(id[i]);*/
		
		while(id[i] != i) i = id[i];
		return i;
	}
	
	// Two objects are connected if the roots are same
	public boolean connected(int p, int q){
		return (root(p) == root(q));
	}
	
	
	// change the root f p to root of q
	public void union(int p, int q){
		id[root(p)] = root(q); // id[root(q)] will be root(q)
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
