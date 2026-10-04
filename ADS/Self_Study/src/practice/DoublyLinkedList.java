package practice;

public class DoublyLinkedList <T> {
	
	class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;
		
		Node(T data){
			this.data = data;
		}
	}
		
	Node<T> head;
	Node<T> tail;
	int size;
			
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public void addAtBeginning(T value) {
		Node<T> newNode = new Node<>(value);

//			list empty!!			
		if(isEmpty()) {
			head = tail = newNode;
		}
		else {				
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	public void addAtEnd(T value) {
		
		Node<T> newNode = new Node<>(value);
		
		if(isEmpty()) {
			head = tail = newNode;
		}
		else {
//				without using tail
			Node<T> current = head;
			while(current.next != null) {
				current = current.next;
			}
			newNode.prev = current;
			current.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public void deleteFromBeginning() {
		if(isEmpty()) {
			throw new IllegalStateException("Empty!!");
		}
		if(head.next == null) {
			head = tail = null;
		}
		else {
			head = head.next;
			head.prev = null;				
		}
		size--;
	}
	
	public void deleteFromEnd() {
		if(isEmpty())
			throw new IllegalStateException("Empty!!");
		
//			only one node
		if(head.next == null) 
			head = tail = null;
		else {
			Node<T> current = head;
			while(current.next.next != null) {
				current  = current.next;
			}
			current.next.prev = null;
			current.next = null;
			tail = current;			
		}
		size--;	
	}
	
//		public void deleteByValue(T value) {
//			if(isEmpty())
//				throw new IllegalStateException("Empty!!");
//			
//			Node<T> current = head;
//			
//			while(current != null) {
//				if(current.data.equals(value)) {
//					if(current == head)
//						deleteFromBeginning();
//					else if(current == tail)
//						deleteFromEnd();
//					else {
//						current.prev.next = current.next;
//						current.next.prev = current.prev;
//					}
//					size--;
//				}
//			
//			current = current.next;
//			}
//			System.out.println("Value not found!!");
//		}
	
	
	public void deleteByValue(T value) {
		if(isEmpty())
			throw new IllegalStateException("Empty!!");
		
		Node<T> current = head;
		
		if(head.data.equals(value)) {
			deleteFromBeginning();
			return;
		}
		else if(tail.data.equals(value)) {
			deleteFromEnd();
			return;
		}
		else {
			while(current.next != null) {
				if(current.data.equals(value)) {
					current.prev.next = current.next;
					current.next.prev = current.prev;
					size--;
					return;
				}
				current = current.next;
			}
		}
		System.out.println("Not found!!");
	}
	
	
	public void reverse() {
		Node<T> current = head;
		Node<T> prev = null;
		Node<T> next;
		
		while(current.next != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
	}
	
	
	public String display() {
		Node<T> current = head;
		
		StringBuilder sb = new StringBuilder("head-> ");
		while(current != null) {
			sb.append(current.data).append(" ");
			current = current.next;
		}
		
		return sb.append(" <- tail").toString();
	}
	
}
	


class Entry{
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		list.addAtBeginning(10);
		list.addAtBeginning(20);
		list.addAtBeginning(30);
		list.addAtBeginning(40);
		list.addAtBeginning(50);
		list.addAtBeginning(60);
		System.out.println(list.display());
		
		list.reverse();
		System.out.println(list.display());
		
	}
}
