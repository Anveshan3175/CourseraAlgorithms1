package sort;

import java.util.Arrays;

public class InsertionSort {

	@SuppressWarnings(value = { "rawtypes" })
	public static void sort(Comparable[] elements){
		
		for(int i = 1; i < elements.length; i++){
			for(int j = i; j > 0; j--){
				if(SortUtil.less(elements[j], elements[j-1])){
					SortUtil.exchange(elements, j, j-1);
					System.out.println(Arrays.toString(elements));
				}
				else {
					break;
				}
			}
		}
	}
}
