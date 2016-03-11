package binaryheap;

import java.util.Arrays;

public class BinaryHeap<Key extends Comparable<Key>> { // its like T extends Comparable<T>

	private Key[] items;
	private int currIndex;
	
	BinaryHeap(Key[] items){
		this.items = items;
		currIndex = 0;  
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
