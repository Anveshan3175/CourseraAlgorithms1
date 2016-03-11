package binaryheap;

import org.junit.Before;
import org.junit.Test;

public class BinaryHeapJUnit {

	BinaryHeap<Integer> bh;
	@Before
	public void setUp() throws Exception {
		Integer[] a = new Integer[10];
		bh = new BinaryHeap<Integer>(a);
	}

	@Test
	public void test() {
		bh.insert(32);
		bh.insert(47);
		bh.insert(5);
		bh.insert(98);
		bh.delMax();
		System.out.println(bh);
		bh.insert(59);
		bh.insert(72);
		bh.insert(16);
		bh.insert(62);
		bh.insert(81);
		bh.delMax();
		System.out.println(bh);
	}

}
