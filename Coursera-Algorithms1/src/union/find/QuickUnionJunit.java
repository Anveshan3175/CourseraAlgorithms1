package union.find;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * For M union-find operations on a set of N objects
 * QF -> MN
 * QU -> MN
 * Weighted QU -> N+ M logN
 * QU + Path Compression -> N + M logN
 * Weighted QU + Path Compression -> N + log*N
 */
public class QuickUnionJunit {

	private QuickUnionUF uf;
	private WeightedQuickUnionUF wuf;
	
	
	@Before
	public void setUp() throws Exception{
		uf = new QuickUnionUF(10);
		wuf = new WeightedQuickUnionUF(10);
	}
	
	@Test
	public void testConnected(){
		uf.union(4, 3);
		uf.union(3, 8);
		uf.union(6, 5);
		uf.union(9, 4);
		uf.union(2, 1);
		assertEquals(true,uf.connected(8, 9));
		assertEquals(false,uf.connected(5, 4));
		uf.union(5, 0);
		uf.union(7, 2);
		uf.union(6, 1);
		uf.union(7, 3);
		
		
		System.out.println(uf);
	}
	
	//@Test
	public void testWConnected(){
		wuf.union(4, 3);
		System.out.println(wuf);
		wuf.union(3, 8);
		System.out.println(wuf);
		wuf.union(6, 5);
		System.out.println(wuf);
		wuf.union(9, 4);
		System.out.println(wuf);
		wuf.union(2, 1);
		System.out.println(wuf);
		assertEquals(true,wuf.connected(8, 9));
		assertEquals(false,wuf.connected(5, 4));
		wuf.union(5, 0);
		System.out.println(wuf);
		wuf.union(7, 2);
		System.out.println(wuf);
		wuf.union(6, 1);
		System.out.println(wuf);
		wuf.union(7, 3);
		
		
		System.out.println(wuf);
	}

}
