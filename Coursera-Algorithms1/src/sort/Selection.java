package sort;

import shuffles.KnuthShuffle;

public class Selection {

	public static Comparable getElement(Comparable[] items, int k){
		int low = 0;
		int high = items.length-1;
		
		KnuthShuffle.shuffle(items);
		
		while(high > low){
			int pIndex = SortUtil.partition(items, low, high);
			
			if(k > pIndex){
				low = pIndex + 1;
			}
			else if (k < pIndex){
				high = pIndex - 1;
			}
			else 
				return items[k];
		}
		return items[k];
	}
}
