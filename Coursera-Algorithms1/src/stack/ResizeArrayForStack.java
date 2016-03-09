package stack;

public class ResizeArrayForStack {

	private int[] array;
	private int curPos;
	
	ResizeArrayForStack(){
		array = new int[1];
		curPos = 0;
	}
	
	public void push(int newInt){
		
		if(curPos >= array.length) {
			resizeArray(array.length * 2); // double the size of array when it is full
		}
		array[curPos++] = newInt;
	}
	
	
	public int pop(){
		int element = array[--curPos];	
		if(curPos < array.length/4)
		{
			resizeArray(array.length/2); // half the array when it is quarter full
		}
		return element;
	}
	
	private void resizeArray(int currentSize) {
		int[] tempArray = new int[currentSize];
		for(int i =0;i<currentSize;i++){
			tempArray[i] = array[i];
		}
		array = tempArray;
	}
	
	public int size(){
		return curPos;
	}
}
