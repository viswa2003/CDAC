package day2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularDeque <T> {

	private Object[] deque;
	int front = 0;
	int size = 0;
	
	public CircularDeque(int capacity) {
		deque = new Object[Math.max(capacity, 1)];
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("front->");
		for(int i = 0; i < size; i++) {
			sb.append(deque[(front + i) % deque.length] + " ");
		}
		return sb.append("<- rear").toString();
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void addFirst(T item) {
		if(size == deque.length) {
			grow();
		}
		front = (front - 1 + deque.length) % deque.length;
		deque[front] = item;
		size++;		
		System.out.println("front-> " + Arrays.toString(deque)+ "<- rear");
		System.out.println("Added " + item);
	}
	
	public void addLast(T item) {
		if(size == deque.length) {
			grow();
		}
		int back = (front + size) % deque.length;
		deque[back] = item;
		size++;
		System.out.println("front-> " + Arrays.toString(deque)+ "<- rear");
		System.out.println("Added " + item);
	}
	
	@SuppressWarnings("unchecked")
	public T removeFirst() {
		if(size == 0)
			throw new NoSuchElementException("");
		
		T item = (T) deque[front];
		deque[front] = null;
		front = (front + 1) % deque.length;
		size--;
		System.out.println("Removed " + item);
		System.out.println("front-> " + Arrays.toString(deque)+ "<- rear");
		return item;
	}
	
	@SuppressWarnings("unchecked")
	public T removeLast() {
		if(size == 0) 
			throw new NoSuchElementException("");
		int rear = (front + size - 1) % deque.length;
		T item = (T) deque[rear];
		deque[rear] = null;
		size--;
		System.out.println("Removed " + item);
		System.out.println("front-> " + Arrays.toString(deque)+ "<- rear");
		return item;
	}
	
	@SuppressWarnings("unchecked")
	public T peekFirst() {
		if(size == 0) 
			throw new NoSuchElementException("");
		T item = (T) deque[front];
		return item;
	}
	
	@SuppressWarnings("unchecked")
	public T peekLast() {
		if(isEmpty())
			throw new NoSuchElementException("");
		
		int rear = (front + size - 1) % deque.length;
		return (T) deque[rear];
	}
	
	
	public void grow() {
		int oldCapacity = deque.length;
		int newCapacity = Math.max((oldCapacity + (oldCapacity / 2)), 1);
		Object[] bigger = new Object[newCapacity];
		
		for(int i = 0; i < size; i++) {
			bigger[i] = deque[(front + i) % deque.length];
		}
		deque = bigger;
		front = 0;
		System.out.println("Deque growed!! New Size : " + newCapacity);
		
	}
	
				
}


class Entry {
	public static void main(String[] args) {
		CircularDeque<Integer> deque = new CircularDeque<Integer>(10);
		
		deque.addFirst(10);
		deque.addFirst(20);
		deque.addFirst(30);
		deque.addFirst(40);
		deque.addFirst(50);
		deque.addLast(10);
		deque.addLast(20);
		deque.addLast(30);
		deque.addLast(40);
		deque.addLast(50);
		deque.addLast(60);
		
		System.out.println(deque);
		
		deque.removeFirst();
		deque.removeFirst();
		deque.removeFirst();
		System.out.println(deque);
		
		deque.removeLast();
		deque.removeLast();
		deque.removeLast();
		deque.removeLast();
		System.out.println(deque);
	}
}
