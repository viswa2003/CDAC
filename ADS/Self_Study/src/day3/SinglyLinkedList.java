package day3;

public class SinglyLinkedList <T>{

    public static class Node<T> {

        T data;
        Node<T> next;

        public Node(T data){
            this.data = data;
            next = null;
        }
    }

    Node<T> head; 
    Node<T> tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private Node<T> nodeAt(int index) {
        Node<T> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        
        if(tail == null) {
            tail = newNode;
        }
        size ++;
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        
        // with tail reference
        if(head == null) {
            head = newNode;
            tail = newNode;
            size ++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size ++;

        // // without tail - traverse
        // ============================

        // if(head == null) {
        //     head = newNode;
        //     return;
        // }
        // Node<T> current = head;
        // while(current.next != null) {
        //     current = current.next;
        // }
        // current.next = newNode;

    }

    public void add(int index, T item) {
        if(index < 0 || index > size) {
            throw new IllegalStateException("index out of scope!!");
        }
        if(index == 0){ 
            addFirst(item);
            return;
        }
        if(index == size) {
            addLast(item);
            return;
        }
        Node<T> newNode = new Node<>(item);
        Node<T> prev = nodeAt(index - 1);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public T removeFirst() {
        if(head == null) {
            throw new IllegalStateException("Empty list!!");
        }
        T removed = head.data;
        head = head.next;
        size --;
        return removed;
    }

    public T removeLast() {
        if(size == 0)
            throw new IllegalStateException("List empty!!");
        if(head == tail) {
            removeFirst();
        }
        Node<T> prev = head;
        while(prev.next != null) {
            prev = prev.next;
        }
        T removed = tail.data;
        tail = prev;
        prev.next = null;
        size--;
        return removed;
        
    }
    
    public void remove(T item) {
        if(head == null)
            return;

        if(head.data == item) {
            head = head.next;

            if(head == null) {
                tail = null;
            }
            return;
        }

        Node<T> current = head;
        while(current.next != null && current.next.data != item) {
            current = current.next;
        }
        if(current.next == null) {
            return;
        }
        current.next = current.next.next;
    }

    public T get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalStateException("No such element!!");
        // Node<T> current = head;
        // for(int i = 0; i < index; i++) {
            //     current = current.next;
            // }
            // return current.data;
            
        return nodeAt(index).data;
    }

    public void reverse(){
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next;
        tail = head;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(10);
    }

}