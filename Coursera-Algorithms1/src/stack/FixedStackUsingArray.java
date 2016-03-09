package stack;

public class FixedStackUsingArray {
	
	private int capacity;
	String[] sArr = new String[capacity];
	private int end = 0;
	
	FixedStackUsingArray(int capacity){
		this.capacity = capacity;
	}
	
	public void push(String str){
		if(end >= capacity){
			System.out.println("Stack is full");
		}
		else {
			sArr[end++] = str;
		}
	}
	
	public String pop(){
		if(end == 0 ){
			System.out.println("Stack is empty");
			return null;
		}
		else {
			String item = sArr[--end];
			sArr[end] = null;
			return item;
		}
	}
	
	public boolean isEmpty(){
		return end == 0;
	}
	
}
