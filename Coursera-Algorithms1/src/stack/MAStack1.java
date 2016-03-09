package stack;

import java.util.Iterator;

public class MAStack1<E>{

	private Node<E> first;
	int size;
	
	
	public Iterator<E> iterator(){
		return  new StackIterator();
	}
	private class StackIterator implements Iterator<E>{

		private Node<E> current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current.next != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			Node<E> node = current.next;
			current = current.next;
			return node.value;
		}
		
	}
	
	
	public boolean isEmpty(){
		return first == null;
	}
	public void push(E item){
		if(first == null){
			first = new Node<E>(item);
			first.next = null;
		}
		else {
			Node<E> oldFirst = first;
			first = new Node<E>(item);
			first.next = oldFirst;
		}
		size++;
	}
	
	public E pop(){
		
		if(first == null){
			System.out.println("Stack is empty");
			return null;
		}
		else {
			E e  = first.value;
			first = first.next;
			size--;
			return e;
		}
	}
	
	
	
	

	
	class Node<S> {
		
		S value;
		Node<S> next;
		
		Node(S value){
			this.value = value;
		}
		
		public String toString(){
			return value.toString();
		}
	}
}
