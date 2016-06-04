package p2.UnionFind;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

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
			
			QuickUnionUF uf = new QuickUnionUF(N);
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
			
			Pair is (4,3)  Current status of array : [0, 1, 2, 3, 3, 5, 6, 7, 8, 9]
			Pair is (3,8)  Current status of array : [0, 1, 2, 8, 3, 5, 6, 7, 8, 9]
			Pair is (6,5)  Current status of array : [0, 1, 2, 8, 3, 5, 5, 7, 8, 9]
			Pair is (9,4)  Current status of array : [0, 1, 2, 8, 3, 5, 5, 7, 8, 8]
			Pair is (2,1)  Current status of array : [0, 1, 1, 8, 3, 5, 5, 7, 8, 8]
			Pair is (8,9)  They are already connected
			Pair is (5,0)  Current status of array : [0, 1, 1, 8, 3, 0, 5, 7, 8, 8]
			Pair is (7,2)  Current status of array : [0, 1, 1, 8, 3, 0, 5, 1, 8, 8]
			Pair is (6,1)  Current status of array : [1, 1, 1, 8, 3, 0, 5, 1, 8, 8]
			Pair is (1,0)  They are already connected
			Pair is (6,7)  They are already connected
			
			Final status of array : [1, 1, 1, 8, 3, 0, 5, 1, 8, 8]
		 */

}
