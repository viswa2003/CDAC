package day2;
import java.util.Arrays;

class BasicArray {

    static int shifts;

    static <T> void insertAtIndex(T[] arr, int index, int size, T value) {
        for(int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
            shifts++;
        }
        arr[index] = value;
    }

    static <T> void removeAtIndex(T[] arr, int index, int size) {
        for(int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
            shifts++;
        }
        arr[size - 1] = null;
    }


    public static void main(String[] args) {

        Integer[] intArr = {1,2,3,4,5,6,7,8,9, null};

        String[] strArr = {"A", "B", "C", "D", "E", null};

        insertAtIndex(intArr, 4, 9, 99);
        System.out.println(Arrays.toString(intArr) + "Shifts : " + shifts);
        
        shifts = 0;
        removeAtIndex(intArr, 6, 10);
        System.out.println(Arrays.toString(intArr) + "Shifts : " + shifts);
        
        shifts = 0;
        insertAtIndex(strArr, 4, 5, "Z");
        System.out.println(Arrays.toString(strArr) + " Shifts : " + shifts);
        shifts = 0;
        removeAtIndex(strArr, 2, 6);
        System.out.println(Arrays.toString(strArr) + " Shifts : " + shifts);


    }

}