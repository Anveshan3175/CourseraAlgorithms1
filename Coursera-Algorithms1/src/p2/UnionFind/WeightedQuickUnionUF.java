package p2.UnionFind;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/*  1. The objects for which connectivity is to be find are integers in this implementation.
 *  2. The integers(objects) are indices of array.
 *  3. The connectivity is established by manipulating the values at the indices.
 */

public class WeightedQuickUnionUF {

	
	private int[] id;
	private int[] size;
	
	WeightedQuickUnionUF(int N){
		id = new int[N];
		size = new int[N];
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
	public boolean connected(int p, int q){
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
		
		System.out.println("Current status of array : "+Arrays.toString(id));
	}
	
	
	// client code 
			public static void main(String[] args) {
				Scanner scan = null;
				try {
					//scan = new Scanner(new File("tinyUF.txt"));
					scan = new Scanner(new File("C://Workspace//GitHub//CourseraAlgorithms1//Coursera-Algorithms1//src//p2//UnionFind//tinyUF.txt"));
					
				} catch (Exception ex) {
					System.out.println("Could not find file");
				}
				
				//solve dynamic connectivity problem
				int N = scan.nextInt();// read number of sites.
				System.out.println("Array length is: " + N);
				
				WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
				System.out.println("Inital status of array : "+Arrays.toString(uf.id) +"\n");
				
				while (scan.hasNext()){
					 int p = scan.nextInt();
					 int q = scan.nextInt(); //read pair to connect
					 System.out.print("Pair is ("+p+","+q+")  ");
					 if (uf.connected(p, q)){
						 System.out.println("They are already connected");
						 continue; //ignore if connected
					 }
					 
					 uf.union(p, q); //combine components
				}
				scan.close();
				System.out.println();
				System.out.println("Final status of array : "+Arrays.toString(uf.id));
			}
			
			/*
			 * Array length is: 10
				Inital status of array : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
				
				Pair is (4,3)  Current status of array : [0, 1, 2, 4, 4, 5, 6, 7, 8, 9]
				Pair is (3,8)  Current status of array : [0, 1, 2, 4, 4, 5, 6, 7, 4, 9]
				Pair is (6,5)  Current status of array : [0, 1, 2, 4, 4, 6, 6, 7, 4, 9]
				Pair is (9,4)  Current status of array : [0, 1, 2, 4, 4, 6, 6, 7, 4, 4]
				Pair is (2,1)  Current status of array : [0, 2, 2, 4, 4, 6, 6, 7, 4, 4]
				Pair is (8,9)  They are already connected
				Pair is (5,0)  Current status of array : [6, 2, 2, 4, 4, 6, 6, 7, 4, 4]
				Pair is (7,2)  Current status of array : [6, 2, 2, 4, 4, 6, 6, 2, 4, 4]
				Pair is (6,1)  Current status of array : [6, 2, 6, 4, 4, 6, 6, 2, 4, 4]
				Pair is (1,0)  They are already connected
				Pair is (6,7)  They are already connected
				
				Final status of array : [6, 2, 6, 4, 4, 6, 6, 2, 4, 4]
			 */

}
