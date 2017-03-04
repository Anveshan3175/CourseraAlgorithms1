package com.two.stacks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackImpleJunit {

	
	DoubleLinkedStackOfStrings stack1;
	LinkedStackOfStrings stack;
	
	@Before
	public void setUp(){
		stack1 = new DoubleLinkedStackOfStrings();
		stack = new LinkedStackOfStrings();
	}
	
	@Test
	public void test() {
		
		stack.push("to");
		stack.push("be");
		stack.push("or");
		stack.push("not");
		stack.push("to");
		assertEquals("to", stack.pop());
		stack.push("be");
		assertEquals("be", stack.pop());
		assertEquals("not", stack.pop());
		stack.push("that");
		assertEquals("that", stack.pop());
		assertEquals("or", stack.pop());
		assertEquals("be", stack.pop());
		stack.push("is");
		stack.printAllValues();
		
		
		
	}
	
	@After
	public void dismiss(){
		stack = null;
	}

}
