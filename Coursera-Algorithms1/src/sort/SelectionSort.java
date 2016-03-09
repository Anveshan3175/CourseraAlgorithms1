package sort;

public class SelectionSort {

	public static void  sort(Comparable[] elems){
		
		int minElemIndex;
		for(int i = 0; i < elems.length; i++){
			minElemIndex = i;
			for (int j = i+1;j < elems.length; j++){
				//if(elems[j].compareTo(elems[minElemIndex]) < 0) {
				if(SortUtil.less(elems[j], elems[minElemIndex])) {
					minElemIndex = j;
				}
			}
			
			//if(minElemIndex != i){
				SortUtil.exchange(elems, i, minElemIndex);
			//}
		}
	}
}
