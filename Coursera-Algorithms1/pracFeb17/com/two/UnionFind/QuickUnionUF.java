package com.two.UnionFind;

import java.util.Arrays;

public class QuickUnionUF implements UF {

	private int[] id;

	QuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {  // N array access
			id[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		// TODO Auto-generated method stub
		//id[root(p)] = root(q);
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}

	@Override
	public boolean connected(int p, int q) {
		// TODO Auto-generated method stub
		return (root(p) == root(q));   // p and q array access
	}
	
	// Using recursion
	private int root1(int p){
		if(id[p] == p)
			return p;				
		return root(id[p]);
	}
	
	// Using loop
	private int root(int p){     // p Array access
		while(id[p] != p)
			p = id[p];
		return p;
	}
	
	public static void main(String[] args){
		
		QuickUnionUF qf = new QuickUnionUF(10);
		System.out.println(Arrays.toString(qf.id));
		qf.union(4, 3);
		System.out.println(Arrays.toString(qf.id));
		qf.union(3, 8);
		System.out.println(Arrays.toString(qf.id));
		qf.union(6, 5);
		System.out.println(Arrays.toString(qf.id));
		qf.union(9, 4);
		System.out.println(Arrays.toString(qf.id));
		qf.union(2, 1);
		System.out.println(Arrays.toString(qf.id));
		System.out.println("8 connected to 9 ? "+qf.connected(8, 9));
		System.out.println("5 connected to 4 ? "+qf.connected(5, 4));
		qf.union(5,0);
		System.out.println(Arrays.toString(qf.id));
		qf.union(7,2);
		System.out.println(Arrays.toString(qf.id));
		qf.union(6,1);
		System.out.println(Arrays.toString(qf.id));
		qf.union(7,3);
		System.out.println(Arrays.toString(qf.id));
	}

}
