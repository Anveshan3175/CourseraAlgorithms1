package sort;

import java.util.Arrays;

public class ShellSort {

	@SuppressWarnings(value = { "rawtypes" })
	public static void sort(Comparable[] items){
		int gap = items.length/2;
		while(gap >= 1){
			System.out.println("Current gap is "+gap);
			for(int i = gap; i < items.length; i = i+gap){  // Trick is initialize and increment with gap
				for(int j = i; j > 0; j = j-gap){
					if(SortUtil.less(items[j], items[j-gap])){
						SortUtil.exchange(items, j, j-gap);
						System.out.println(Arrays.toString(items));
					}
					else {
						break;
					}
				}
			}
			gap = gap/2;
		}
		System.out.println("Shell sort completed");
	}
}
