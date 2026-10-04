package day2;
import java.util.Arrays;

class LinearQueue <T> {

    private final Object[] queue;
    int front = -1;
    int rear = -1;

    public LinearQueue(int capacity) {
        queue = new Object[capacity];
    }
    

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return rear == queue.length - 1;
    }

    public void enqueue(int item) {
        if(isFull()) 
            throw new IllegalStateException("Queue Overfllow : rear is at the end!!");
        if(front == -1)
            front = 0;
        rear ++;
        queue[rear] = item;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if(isEmpty()) 
            throw new IllegalStateException("Queue underflow");
        T removed = (T)queue[front];
        queue[front] = null;
        front++;
        return removed;
    }

    public String toString() {
        return Arrays.toString(queue);
    }


    public static void main(String[] args) {

        LinearQueue<Integer> queue = new LinearQueue<>(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue);
        System.out.println(queue.isFull());
        
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        
    }

}