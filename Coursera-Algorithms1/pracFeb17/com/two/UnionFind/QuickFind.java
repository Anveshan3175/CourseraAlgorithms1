package com.two.UnionFind;

import java.util.Arrays;

public class QuickFind {
	
	private int[] id ;
	
	QuickFind(int N){
		id = new int[N];
		for(int i = 0; i < N; i++){ //N array access
			id[i] = i;
		}
	}

	// Two objects are connected iff they have same id
	public boolean connected(int a, int b){
		return (id[a] == id[b]);  // 2N array access
	}
	
	//Whatever is there in index of second argument,populate it in first index
	// Check all elements  where in value is same as that of first index
	// if Union operation is invoked N times, then N*N array access to process sequence of N union
	// commands  ==> Union is too expensive  Quadratic time is too slow..don't accept quadratic 
	// algorithms..They don't scale for large data
	public void union(int a,int b){
		int temp = id[a];
		for(int i = 0; i < id.length; i++){
			if(id[i] == temp){
				id[i] = id[b];  // 2N + 1 array access
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickFind id = new QuickFind(10);
		System.out.println(Arrays.toString(id.id));
		id.union(4,3);
		System.out.println(Arrays.toString(id.id));
		id.union(3, 8);
		System.out.println(Arrays.toString(id.id));
		id.union(6, 5);
		System.out.println(Arrays.toString(id.id));
		id.union(9, 4);
		System.out.println(Arrays.toString(id.id));
		id.union(2, 1);
		System.out.println(Arrays.toString(id.id));
		id.union(8, 9);
		System.out.println(Arrays.toString(id.id));
		
		System.out.println("0 and 5 connected ? "+id.connected(5,0));
		
		id.union(5, 0);
		System.out.println(Arrays.toString(id.id));
		id.union(7, 2);
		System.out.println(Arrays.toString(id.id));
		id.union(6, 1);
		System.out.println(Arrays.toString(id.id));
	}

}


