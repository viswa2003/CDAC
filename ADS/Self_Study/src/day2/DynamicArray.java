package day2;
import java.util.Arrays;

class DynamicArray <T> {

    private Object[] array;
    private int size;

    public DynamicArray() {
        array = new Object[1];
    }

    public DynamicArray(int capacity) {
        array = new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public int length() {
        return array.length;
    }

    public void add(T item) {
        if(size == length()) {
            grow();
        }
        array[size++] = item;
        System.out.println(Arrays.toString(array));
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(index < 0 || index >= size) 
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        return (T) array[index];
    }

    public <T> void set(int index, T item) {
        if(index < 0 || index >= size) 
            throw new IndexOutOfBoundsException("Index : " + index + ", size : " + size);
        array[index] = item;
        System.out.println(Arrays.toString(array));
    } 

    @SuppressWarnings("unchecked")
    public T removeAt(int index) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("index : " + index + ", size : " + size);

        T removed = (T)array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);  
        //arraycopy(source, source starting position, destination, destination starting position, length)
        
        array[size - 1] = null;
        size--;
        System.out.println(Arrays.toString(array) + " removed from index " + index);
        return removed;
    }

    private void grow() {
        int oldCapacity = array.length;
        int newCapacity = Math.max((oldCapacity + oldCapacity / 2), oldCapacity + 1);
        this.array = Arrays.copyOf(this.array, newCapacity); 
        System.out.println("Before growth : " + oldCapacity + " After growth : " + newCapacity);
    }



    public static void main(String[] args) {

        DynamicArray<Integer> intArr = new DynamicArray<>();

        intArr.add(10);
        intArr.add(20);
        intArr.add(30);
        intArr.add(40);
        intArr.add(50);
        intArr.add(60);
        intArr.add(70);
        intArr.add(80);
        intArr.add(90);

        System.out.println("size : " + intArr.size() + "Length : " + intArr.length());
        intArr.removeAt(3);
        System.out.println("size : " + intArr.size() + "Length : " + intArr.length());
    }


}