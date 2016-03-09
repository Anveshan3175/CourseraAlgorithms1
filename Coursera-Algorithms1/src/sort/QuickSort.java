package sort;

import java.util.Arrays;

import shuffles.KnuthShuffle;

public class QuickSort {
	
	public static void aSort(Comparable[] items,int low,int high){
		
		if(low < high){
			int pIndex = getPivot(items,low,high);
			aSort(items,low,pIndex-1);
			aSort(items,pIndex+1,high);
		}
	}
	
	private static int getPivot(Comparable[] items,int low,int high){
		int pIndex = low; // partition index
		Comparable pivot = items[high]; // pivot
		for(int i = low; i <= high-1; i++){
			if(SortUtil.less(items[i], pivot)){
				SortUtil.exchange(items, i, pIndex); // if all elements are less than pivot, then exchange/swap happens on same element
				pIndex++;
			}
		}
		SortUtil.exchange(items, pIndex, high);
		return pIndex;
	}
	
	// coursera sort shuffle is called when first time sort is called
	public static void cSort(Comparable[] items,int low,int high){
		if(low < high){
			//int pIndex = getPartitionIndex(items,low,high);
			int pIndex = SortUtil.partition(items, low, high);
			cSort(items,low,pIndex-1);
			cSort(items,pIndex+1,high);
		}
	}
	
	private static int getPartitionIndex(Comparable[] items,int low,int high){
		int pIndex = high;
		int pivot = low;
		int i = low+1;
		
		//for(int k = low+1;k <= high;k++){
			//i = k;
		while(pIndex > i){
			
			if(!SortUtil.less(items[i], items[pIndex])){
				SortUtil.exchange(items, i, pIndex);
			}
			if(SortUtil.less(items[i], items[pivot])) i++;
			if(!SortUtil.less(items[pIndex], items[pivot])) pIndex--;
		}
		if(!SortUtil.less(items[pivot], items[pIndex]))
		SortUtil.exchange(items, pivot, pIndex);
		return pIndex;
	}
	
	// when there are repetitive keys, then we need to use 3 way partition index
	public static void iSort(Comparable[] items, int low, int high){
		
		if(high <= low) return;
		int i = low, lt = low,gt = high;
		Comparable v = items[low]; 
		
		while(i <= gt ) {
			int cmp = items[i].compareTo(v);
			if(cmp < 0) SortUtil.exchange(items, lt++, i++); // increment both i and lt
			else if (cmp > 0) SortUtil.exchange(items, gt--, i); // only decrement gt // when i = gt then also this is executed and hence g+1 works in recursion
			else i++; // increment only i .. So lt may  point to value equal to pIndex. Hence reduce it by 1 while recursive call
			          // Since the first value is v , so first i increments leaving lt trailing
			System.out.println("Finished Quick sort with these inputs :"+Arrays.toString(items));
		}
		// now we have got 3 partition points. Hence call sort again on those points like normal Quick sort
		iSort(items,low,lt-1);
		iSort(items,gt+1,high);
	}

}
