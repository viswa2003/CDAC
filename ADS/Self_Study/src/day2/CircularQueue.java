package day2;


class CircularQueue <T> {

    Object[] queue;
    int front = 0;
    int rear = -1;
    int size = 0;

    public CircularQueue(int capacity) {
        queue = new Object[capacity];
         System.out.println("Queue created of size : " + capacity);
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == queue.length;
    }

    public void enqueue(T item) {
        if(isFull())
            throw new IllegalStateException("Queue overflow !!");

        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;

        System.out.println(this);
    }
    
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if(isEmpty()) 
            throw new IllegalStateException("Queue underflow");
        
        T removed = (T) queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        System.out.println(this + "  removed : " + removed);
        return removed;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) queue[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("front -> ");
        for(int i = 0; i < size; i++) {
            sb.append(queue[(front + i) % queue.length]).append(" ");
        }

        return sb.append(" <- rear").toString();
    }


    public static void main(String[] args) {

        CircularQueue<Integer> queue = new CircularQueue<Integer>(10);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        queue.dequeue();
        
        queue.enqueue(50);
        queue.enqueue(50);
        queue.enqueue(50);
        queue.enqueue(50);
        queue.enqueue(50);
        queue.enqueue(50);

    }


}