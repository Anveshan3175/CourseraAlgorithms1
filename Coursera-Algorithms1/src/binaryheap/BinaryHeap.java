package binaryheap;

import java.util.Arrays;

public class BinaryHeap<Key extends Comparable<Key>> { // its like T extends Comparable<T>

	private Key[] items;
	private int currIndex;
	
	BinaryHeap(Key[] items){
		this.items = items;
		currIndex = 0;  
	}
	
	// You pass an array, the method will form proper Binary heap and sort it.
	public void sort(Comparable[] pq){
		int N = pq.length;
		
		for(int k = N/2; k > 1; k--){
			sink(pq,k,N);
		}
		while(N > 1){
			exchange(pq, 1, N);
			sink(pq,1,--N);
		}
	}
	
	private void exchange(Comparable[] pq, int i, int j){
		Comparable temp = pq[i];
		pq[i] = pq[j] ;
		pq[j] = temp;
	}
	
	// FInd out which of the two childs is bigger ad swap it with root
	private void sink(Comparable[] pq, int k,int high){
		while (2 * k <= high){
			int j = 2 * k;
			if(j < high && less(j,j+1)) j = j+1;
			if(!less(k,j)) break;
			exchange(k,j);
			k = j;
		}
	}
	
	
	
	public void sort(){
		int high = currIndex;
		
		while(high >= 1){
			exchange(high,1);
			sinkForSort(1,--high);
		}
	}
	
	private void sinkForSort(int k,int high){
		while (2 * k <= high){
			int j = 2 * k;
			if(j < high && less(j,j+1)) j = j+1;
			if(!less(k,j)) break;
			exchange(k,j);
			k = j;
		}
	}
	
	public Key delMax(){
		
		Key k = items[1];
		exchange(1,currIndex--);
		sink(1);
		items[currIndex+1] = null; // here are not incrementing the currentIndex
		return k;
	}
	
	private void sink(int k){
		while (2 * k <= currIndex){
			int j = 2 * k;
			if(j < currIndex && less(j,j+1)) j = j+1;
			if(!less(k,j)) break;
			exchange(k,j);
			k = j;
		}
	}
	
	public void insert(Key k){
		items[++currIndex] = k;
		swim(currIndex);
	}
	
	private void swim(int k){
		
		while(k > 1 && less(k/2,k)){
			exchange(k,k/2);
			k = k/2;
		}
	}
	
	private boolean less(int i, int j){
		if(items[i].compareTo(items[j]) < 0)
			return true;
		return false;
	}
	
	private void exchange(int i, int j){
		Key temp = items[i];
		items[i] = items[j] ;
		items[j] = temp;
	}
	
	public String toString(){
		return Arrays.toString(items);
	}
	
}


/*class Key implements Comparable<Key> {

	private Comparable a;
	
	Key (Comparable a){
		this.a = a;
	}
	@Override
	public int compareTo(Key o) {
		// TODO Auto-generated method stub
		return this.a.compareTo(o.a);
	}
	
	public String toString(){
		return a.toString();
	}
	
}*/
