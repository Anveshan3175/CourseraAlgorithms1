package stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMAStack {

	MAStack1<String> stack; 
	FixedStackUsingArray fStack;
	ResizeArrayForStack resizeStack;
	
	@Before
	public void setUp() throws Exception {
		stack = new MAStack1<>();
		fStack = new FixedStackUsingArray(3);
		resizeStack = new ResizeArrayForStack();
	}

	
	@Test
	public void testResizeStack() {
		resizeStack.push(4);
		resizeStack.push(7);
		resizeStack.push(23);
		resizeStack.push(78);
		assertEquals(4, resizeStack.size());
	}
	
	
	//@Test
	public void test() {
		stack.push("First");
		stack.push("Message");
		stack.push("Is");
		assertEquals("Is", stack.pop());
		stack.push("Special");
		stack.push("Careful");
		assertEquals(4, stack.size);
	}
	
	//@Test
	public void testFStack() {
		stack.push("First");
		stack.push("Message");
		stack.push("Is");
		assertEquals("Is", stack.pop());
		stack.push("Special");
		stack.push("Careful");
		assertEquals(4, stack.size);
	}

}
