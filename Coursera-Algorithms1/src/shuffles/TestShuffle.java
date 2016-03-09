package shuffles;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestShuffle {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testKnuthShuffle() {
		Integer[] ints = {1,2,3,4,5,6,7,8};
		
		System.out.println(Arrays.toString(ints));
		KnuthShuffle.shuffle(ints);
		System.out.println(Arrays.toString(ints));
	}

}
