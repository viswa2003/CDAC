package day3;


class CircularLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node (T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;

    private int size;

    public boolean isEmpty() {
        return head == tail;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        if(isEmpty()) {
            addFirst(item);
            return;
        }
        Node<T> newNode = new Node<>(item);
        tail.next = newNode;
        tail = newNode;
        newNode.next = head;
        size++;
    }

}