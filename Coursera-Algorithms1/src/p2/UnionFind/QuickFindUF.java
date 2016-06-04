package p2.UnionFind;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

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
		
		QuickFindUF uf = new QuickFindUF(N);
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
	
}
