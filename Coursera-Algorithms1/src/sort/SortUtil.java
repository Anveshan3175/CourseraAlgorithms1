package sort;

public class SortUtil {

	
	public static void sort(Comparable[] array){
		
		for(int i = 1; i < array.length; i++){
			for(int j = i; j > 0;j--){
				
				if(array[j].compareTo(array[j-1]) < 0) {
					Comparable temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
			
		}
	}
	
	// Helper function for less than
	public static boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0;
	}
	
	// Helper function for swap function
	public static void exchange(Comparable[] array,int i,int j){
		Comparable temp = array[i];
		array[i] = array[j];
		 array[j] = temp;
	}
	
	
	public static boolean isSorted(Comparable[] arr){
		for(int i = 1; i < arr.length ; i++){
			//if(arr[i].compareTo(arr[i-1]) < 0)
			if(less(arr[i],arr[i-1]))  // and exchange method can be used in addition to ensure array is sorted
				return false;
		}
		
		return true;
	}
	
	public static void merge(Comparable[] elements,int low,int high,int mid) {
		
		Comparable[] temp = new Comparable[elements.length];
		int j = mid+1;
		int i = low;
		for(int k = low;k <= high;k++){
			if(j > high) 							temp[k] = elements[i++];   // high sub array is exhausted..so copy all the small sub array
			else if (i > mid) 						temp[k] = elements[j++];   // small sub array is exhausted..so copy all the high sub array
			else if(less(elements[i],elements[j]))  temp[k] = elements[i++];
			else 									temp[k] = elements[j++];
		}
		
		for(int k = low; k <= high;k++){
			elements[k] = temp[k];
		}
	}
	
	
	public static int partition(Comparable[] items, int low,int high){
		int pIndex = high+1;
		int i = low;
		
		while(true){
			
			while(less(items[++i],items[low])){
				if(i == high) break;
			}
			
			while(less(items[low],items[--pIndex])){
				if(pIndex == low) break;
			}
			
			if(i >= pIndex ) break;
			
			exchange(items, pIndex, i);
		}
		
		exchange(items, low, pIndex);
		
		return pIndex;
	}
	
}


