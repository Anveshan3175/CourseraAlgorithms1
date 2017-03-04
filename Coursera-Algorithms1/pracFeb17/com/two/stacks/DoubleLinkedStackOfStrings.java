package com.two.stacks;

public class DoubleLinkedStackOfStrings {

	Node current;
	private class Node {

		Node(String value) {
			this.value = value;
		}

		Node next;
		Node prev;
		String value;
		
		public String toString(){
			return value;
		}
	}
	
	public void push(String item){
		if(current == null){
			current = new Node(item);
		}
		else {
			current.next = new Node(item);
			current.next.prev = current;
			current = current.next;
		}
	}
	
	public String pop(){
		String top = null;
		if(current != null){
			top = current.value;
			current = current.prev;
			current.next = null;
		}
		return top;
	}
	
	public boolean isEmpty(){
		return current == null;
	}
}
