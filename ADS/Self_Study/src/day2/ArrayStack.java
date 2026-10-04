package day2;

import java.util.*;


public class ArrayStack <T>  {
    

    T[] stack;
    int top = -1; 

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        stack = (T[]) new Object[capacity];
    }

    boolean isEmpty() {
        return this.top == -1;
    }

    boolean isFull() {
        return top == stack.length - 1;
    }

    int size() {
        return top + 1;
    }

    void push(T data) {
        if(isFull()){
            throw new IllegalStateException("Stack Overflow!!");
        } 
        else {
            stack[++top] = data;
        }
    }   

    T pop() {
        if(isEmpty()) 
            throw new NoSuchElementException("Stack underflow!!");

        T item = stack[top];
        stack[top--] = null; // To prevent loitering
        return item;
    }

    T peek() {
        return stack[top];
    }

    public static void main(String[] args) {

        ArrayStack<String> stack= new ArrayStack<String>(10);

        System.out.println("Is stack empty : " + stack.isEmpty());

        System.out.println("Is stack full : " + stack.isFull());
        
        stack.push("Viswa");
        
        System.out.println("Top element : " + stack.peek());
        
        stack.push("Abharnna");
        
        stack.push("Anu");
        
        stack.push("Abhi");
        
        while(!stack.isEmpty()) {
                System.out.println("Top element is : " + stack.pop());
            }
            
        }
         
    
}
