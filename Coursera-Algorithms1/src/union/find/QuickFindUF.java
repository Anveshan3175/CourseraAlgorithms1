package union.find;

public class QuickFindUF {

	private int[] id;
	
	public QuickFindUF(int N) {
		id = new int[N];
		for(int i = 0; i < N;i++){ // N iterations for N elements
			id[i] = i;
		}
	}

	
	public boolean connected(int p, int q){
		return (id[p] == id[q]);
	}
	
	//	change root of p's to q's and all all elements which have p's root also need to be changed
	// -- first element will be changed
	// takes N^2 array access to process sequence of N union commands on N objects - for each union it has to iterate all elements
	public void union(int p , int q){
		int temp = id[p];
		
		for(int i = 0 ; i < id.length;i++){
			if(id[i] == temp){
				id[i] = id[q];
			}
		}
	}
}
