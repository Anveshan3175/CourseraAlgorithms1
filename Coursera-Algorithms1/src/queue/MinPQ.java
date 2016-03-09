package queue;

import java.util.Arrays;

public class MinPQ {

	private int[] arr;
	int currentPos = 0;
	
	MinPQ (int length){
		arr = new int[length+1];
	}
	
	public void insert(int a){
		arr[currentPos++] = a;
		deleteMinElement();
	}
	
	public void deleteMinElement(){
		
		if(currentPos == arr.length ){
			int minIndex = 0;
			for (int i = 1; i < arr.length; i++){
				if(arr[minIndex] >  arr[i]) {
					minIndex =  i;
				}
			}
			swap(minIndex,arr.length-1);
			currentPos--;
			arr[currentPos] = -1;
		}
		
	}
	
	public void swap(int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public String toString(){
		
		return (Arrays.toString(arr));
	}
	
}
