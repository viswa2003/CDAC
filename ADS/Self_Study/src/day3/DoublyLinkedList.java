package day3;

class DoublyLinkedList <T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            data = this.data;
            // nuxt and prev will automatically assign to null
        }
    }

    Node<T> head;
    Node<T> tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<T> nodeAt(int index) {
        Node<T> current = head;
        while(current.next != null) {
            current = current.next;
        } 
        return current;
    }


    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if(tail == null) {
            head = tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T item) {
        if(index < 0 || index > size) throw new IllegalStateException("No such index!!");

        if(index == 0) {
            addFirst(item);
        }
        else if(index == size) {
            addLast(item);
        }
        else{
            Node<T> newNode = new Node<>(item);
            Node<T> after = nodeAt(index);
            Node<T> before = nodeAt(index - 1);
            before.next = newNode;
            newNode.prev = before;
            newNode.next = after;
        }
        size++;
    }
}