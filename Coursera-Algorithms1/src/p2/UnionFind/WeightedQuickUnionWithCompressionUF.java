package p2.UnionFind;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class WeightedQuickUnionWithCompressionUF {

	private int[] id;
	private int[] size;
	
	WeightedQuickUnionWithCompressionUF(int N){
		
		id = new int[N];
		size = new int[N];
		
		for(int i = 0; i < N; i++){
			id[i] = i;
			size[i] = 1;
		}
	}
	
	/* 1. Added one line additional for compression
	 * 2. each iteration is done for Node
	 * 3. Make every other node in the path, point  to its grand parent (thereby halving the path length)
	 * 4. This one line will flatten the tree amazingly
	 * 5. We are not changing everything node to root node.
	 */ 
	private int root(int p){
		while(p != id[p]){
			id[p] = id[id[p]]; // this does compression. We are changing the parent node of  node
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q) {
		if(root(p) == root(q))  return;
		
		if(size[p] < size[q]) {
			id[root(p)] =  root(q);
			size[q] += size[p];
		}
		else {
			id[root(q)] =  root(p);
			size[p] += size[q];
		}
		
		System.out.println("Current status of array : "+Arrays.toString(id));
	}
	
	public boolean connected (int p, int q){
		return root(q) == root(p);
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
					
					WeightedQuickUnionWithCompressionUF uf = new WeightedQuickUnionWithCompressionUF(N);
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
			Initial status of array : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
			
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
			
			Final status of array : [6, 6, 6, 4, 4, 6, 6, 6, 4, 4]
		 */

}
