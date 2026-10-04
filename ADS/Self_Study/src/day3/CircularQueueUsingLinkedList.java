package day3;

import java.util.NoSuchElementException;

public class CircularQueueUsingLinkedList {
	
	static class LinkedCircularQueue <T> {
		
		class Node<T> {
			T data;
			Node<T> next;
			
			public Node(T data) {
				this.data = data;
			}
		}
		
		Node<T> rear;
		int size;
		int capacity;
		
		public LinkedCircularQueue(int capacity) {
			rear = null;
			this.capacity = capacity;
			this.size = 0;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public boolean isFull() {
			return size == capacity;
		}
		
		public void enque(T item) {
			if(isFull())
				throw new NoSuchElementException("Queue full!!");
			
			Node<T> newNode = new Node<>(item);
			
			if(isEmpty()) {
				rear = newNode;
				rear.next = newNode;
			}
			else {
				newNode.next = rear.next;
				rear.next = newNode;
				rear = newNode;
			}
			size++;
			
		}
		
		@SuppressWarnings("unchecked")
		public T deque() {
			if(isEmpty())
				throw new NoSuchElementException("Empty!!");
			
			T item = (T) rear.next.data;
			
			if(size == 1) {
				rear = null; //becomes empty
			}
			else {
				rear.next = rear.next.next;
			}
			size--;
			return item;
			
		}
		
		public T peek() {
			if(isEmpty())
				throw new NoSuchElementException("Empty!!");
			T item = rear.next.data;
			return item;
		}
		
		public String display() {
			if(isEmpty())
				return "Queue is empty!!";
			StringBuilder sb = new StringBuilder("front-> ");
			Node<T> current = rear.next;
			do {
				sb.append(current.data).append(" ");
				current = current.next;
			}
			while(current != rear.next);
			return (sb).append("<-rear ").toString();
		}
		
	}
	
	public static void main(String[] args) {
		
		LinkedCircularQueue<Integer> queue = new LinkedCircularQueue<>(5);
		
		queue.enque(10);
		queue.enque(20);

		System.out.println(queue.display());
	}
	
}













