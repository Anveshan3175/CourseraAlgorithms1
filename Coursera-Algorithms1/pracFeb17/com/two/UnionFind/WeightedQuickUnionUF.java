package com.two.UnionFind;

import java.util.Arrays;

//This algorithm scales
public class WeightedQuickUnionUF implements UF{

	private int[] id;
	private int[] sz;

	WeightedQuickUnionUF(int N) {
		id = new int[N];
		sz = new int[N];
		
		for (int i = 0; i < N; i++) {  // N array access
			id[i] = i;
			sz[i] = 1;
		}
	}

	@Override
	public void union(int p, int q) {
		// TODO Auto-generated method stub
		//id[root(p)] = root(q);
		int i = root(p);
		int j = root(q);
		if(i == j) return;  // If both are already having same root no need to proceed.Size shouldn't
		if(sz[i] < sz[j]){  // be updated
			id[i] = j;
			sz[j]+= sz[i];
		}
		else {
			id[j] = i;
			sz[i]+= sz[j];
		}
	}

	@Override
	public boolean connected(int p, int q) {
		// TODO Auto-generated method stub
		return (root(p) == root(q));   // p and q array access
	}
	
		
	// Using loop
	private int root(int p){     // p Array access
		while(p != id[p] ){
			// if id[p] != p, then there will be atleast one which id[id[p]] is valid
			id[p] = id[id[p]];   // For Path compression
			p = id[p];
		}
		return p;
	}
	
	public static void main(String[] args){
		
		WeightedQuickUnionUF qf = new WeightedQuickUnionUF(10);
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
		
		System.out.println("Size Array "+Arrays.toString(qf.sz));
	}

}
