package day1;

import java.util.*;

class LinearSearch {
    public static int linearLearch(int[] arr, int key) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77,88,99};

        System.out.println("Enter key : ");
        int key = sc.nextInt();

        long t = System.nanoTime();

        int index = linearLearch(arr, key);

        System.out.println("The key found at index " + index);

        System.out.printf("Time : %02d ms", (System.nanoTime() - t) / 10_00_000);

    }
}
