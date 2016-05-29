package p2.UnionFind;

// Execution : java QuickFindUF < input.txt

// UnionFind uses data structure which is Array internally
// Find operation id easy
// Union operation is difficult. Need to iterate all entries. if N union operations on N sized array then it is Quadratic time algorithm

public class QuickFindUF {

	private int[] id;
	
	// N iterations
	public QuickFindUF(int N){
		
		id = new int[N];
		// Populating data, Initially set id as object itself
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}
	
	
	// check if both indices are same or not if you have to check objects are connected or not.
	public boolean connected(int p, int q){
		return id[p] == id[q];
	}
	
	
	// At most 2N+2 access
	// N iterations
	public void union(int p,int q){
		
		if(!connected(p,q)){ // Can remove this check as well
			int indexQ = id[q]; // 1 access to array
			int indexP = id[p]; // 2 access to array
			
			for(int i = 0; i < id.length; i++){
				// Change the values at index P to the value at index Q 
				if(id[i] == indexP) id[i] = indexQ; // At most N access each time. One for compare and one for assignment.
			}
		}
	}
	
	
	// client code 
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			
			int N = StdIn.readInt();
			
			UF uf = new UF(N);
			
			while(!StdIn.isEmpty()){
				
				int p = StdIn.readInt();
				int q = StdIn.readInt();
				
				if(!uf.connected(p,q)){
					uf.union(p, q);
					StdOut.println(p+"  "+q);
				}
			}
		}
	
}
