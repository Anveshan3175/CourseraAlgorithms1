package queue;

public class QueueOfInts {

	
	private int[] array;
	private int head;
	private int tail;
	
	QueueOfInts(){
		array = new int[10];
	}
	
	public void enqueue(int element){
		array[tail++] = element;
	}
	
	public int dequeue(){
		return array[head++];
	}
}
