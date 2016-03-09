package sort;

import java.util.Arrays;

public class MergeSort {

	private static Comparable[] aux;
	/*
	 * The Big(O) = nlog(n).
	 * The only cost of operation is N for merging. And merging happens log(n) times.
	 * Hence total cost is nlog(n).
	 * Extra space proportional to N is used
	 */
	
	public static void mergeSort(Comparable[] elements,int low,int high){
		
		if(low < high){
			int  mid = (low+high)/2;
			mergeSort(elements,low,mid);
			mergeSort(elements,mid+1,high);
			SortUtil.merge(elements,low,high,mid);
		}
	}
	
	// NO recursion..first two pair elements are merged. thenn 4 pair,then 6 pair then all are merged
	public static void bottomUpMergeSort(Comparable[] elements,int first,int last){
		
		int high = 0,mid = 0,low = 0;
		for(int i = 1; i < elements.length; i = 2*i ){
			for(int j = 0; j < elements.length; ){
				low = j;
				//high = j + (2*i - 1);
				high = Math.min(j + (2*i - 1), elements.length-1);  // this is critical if high is greater than array size then send only array size
				mid = (low + high)/2;
				System.out.println("inputs to merge- low :"+low+" , mid :"+mid+" , high :"+high);
				SortUtil.merge(elements,low,high,mid);
				System.out.println("After Merge :"+Arrays.toString(elements));
				j = high + 1;
			}
		}
		
	}
	
	public static void bottomUpMergeSort(Comparable[] elements){
		int N = elements.length;
		aux = new Comparable[N];
		
		for(int sz = 1; sz < N; sz = 2*sz){
			for(int lo = 0;lo < N-sz; lo+= sz+sz){
				System.out.println("lo : "+lo +", Math.min(lo+sz+sz-1, N-1) : "+Math.min(lo+sz+sz-1, N-1) +", lo+sz-1 : "+(lo+sz-1));
				SortUtil.merge(elements,lo,Math.min(lo+sz+sz-1, N-1),lo+sz-1);
			}
			
		}
		
	}
}
