package queue;

public class QueueOfStrings {

	private Node first;
	private Node last;
	private int size;
	
	QueueOfStrings(){
		
	}
	
	
	public int size(){
		return size;
	}
	
	public 	boolean isEmpty(){
		return first == null ? true : false;
	}
	
	public String dequeue(){
		String item = null;
		if(first != null){
			size--;
			item = first.value;
			Node node = first.next;
			first = null;
			first = node;
		}	
		return item;
	}
	
	
	
	public void enqueue(String item){
		size++;
		if(first == null) {
			first = new Node(item);
			last = first;
		}
		else {
			Node node = new Node(item);
			last.next = node;
			last = node;
		}
	}
	
	
	
	private class Node {
		
		private String value;
		private Node next;
		
		Node(String value){
			this.value = value;
		}
		
		public String toString(){
			return value;
		}
	}
}
