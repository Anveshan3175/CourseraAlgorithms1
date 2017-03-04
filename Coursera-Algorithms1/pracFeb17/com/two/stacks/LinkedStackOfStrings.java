package com.two.stacks;

public class LinkedStackOfStrings {

	Node first;
	
	private class Node{
		String value;
		Node next;
		
		Node(String value){
			this.value = value;
		}
		public String toString(){
			return value;
		}
	}
	
	public void push(String item){
		if(null == first){
			first = new Node(item);
		}
		else {
			Node newNode = new Node(item);
			newNode.next = first;
			first = newNode;
		}
	}
	
	public String pop(){
		String top = null;
		if(null != first){
			top = first.value;
			first = first.next;
		}
		
		return top;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void printAllValues(){
		Node temp = first;
		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}
