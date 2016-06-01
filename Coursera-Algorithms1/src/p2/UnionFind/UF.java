package p2.UnionFind;

// https://github.com/aistrate/AlgorithmsSedgewick/tree/master/1-Fundamentals/1-5-UnionFind
// http://algs4.cs.princeton.edu/code/
// http://grepcode.com/snapshot/repo1.maven.org/maven2/com.googlecode.princeton-java-algorithms/algorithms/4.0.0/
public class UF {
	
	UF(int N){
		
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
	
	public  void union(int p, int q){
		
	}
	
	public  boolean connected(int p, int q){
		return true;
	}

}
