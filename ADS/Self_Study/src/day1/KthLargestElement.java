package day1;

import java.util.*;

public class KthLargestElement {
    
    public static  int kthLargest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];        
    }

    public static void main(String[] args) {
        Random random = new Random();

        int[] arr = random.ints(10, 10, 100).toArray();

        int k = 2;

        for(int num : arr) System.out.print(num + " ");

        System.out.printf("\nThe %d-th largest element is : %d \n", k, kthLargest(arr, k));
    }

}
