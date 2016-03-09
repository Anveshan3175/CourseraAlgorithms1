package queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestQueue {

	QueueOfStrings strQueue;
	QueueOfInts intQueue;
	
	@Before
	public void setUp() throws Exception {
		
		strQueue = new QueueOfStrings();
		intQueue = new QueueOfInts();
	}

	//@Test
	public void test() {
		
		assertTrue(strQueue.isEmpty());
		strQueue.enqueue("Hi");
		strQueue.enqueue("Hello");
		strQueue.enqueue("namasthe");
		strQueue.enqueue("vankum");
		assertFalse(strQueue.isEmpty());
		strQueue.enqueue("salam");
		System.out.println(strQueue.dequeue());
		System.out.println(strQueue.dequeue());
		assertEquals(strQueue.size(), 3);
	}
	
	@Test
	public void testIntQueue() {
		
		intQueue.enqueue(5);
		intQueue.enqueue(3);
		intQueue.enqueue(9);
		intQueue.enqueue(23);
		intQueue.enqueue(99);
		System.out.println(intQueue.dequeue());
		System.out.println(intQueue.dequeue());
		System.out.println(intQueue.dequeue());
		System.out.println(intQueue.dequeue());
	}

}
