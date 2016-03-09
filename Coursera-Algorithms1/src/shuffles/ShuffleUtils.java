package shuffles;

public class ShuffleUtils {

	
	public static void exchange(Comparable[] arr, int i,int j){
		
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
