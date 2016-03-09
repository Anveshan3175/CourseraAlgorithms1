package queue;

import org.junit.Before;
import org.junit.Test;

public class MinPQJUnit {

	MinPQ priorityQueue;
	
	@Before
	public void setUp() throws Exception {
		priorityQueue = new MinPQ(4);
	}

	@Test
	public void test() {
		priorityQueue.insert(34);
		System.out.println(priorityQueue);
		priorityQueue.insert(21);
		System.out.println(priorityQueue);
		priorityQueue.insert(67);
		System.out.println(priorityQueue);
		priorityQueue.insert(88);
		System.out.println(priorityQueue);
		priorityQueue.insert(43);
		System.out.println(priorityQueue);
		priorityQueue.insert(1);
		System.out.println(priorityQueue);
		priorityQueue.insert(1);
		priorityQueue.insert(1);
		priorityQueue.insert(77);
		System.out.println(priorityQueue);
		priorityQueue.insert(1);
		priorityQueue.insert(1);
		
	}

}
