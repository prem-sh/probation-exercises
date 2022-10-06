package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,8,9,10,88,2,1,4,77};
        int largest = arr[1];
        int secondLargest = 0;
        System.out.println("Array : "+ Arrays.toString(arr));

        for (int i=1; i<arr.length; i++){
            if(secondLargest<arr[i]) secondLargest = arr[i];
            if(largest < secondLargest) {
                int temp = largest;
                largest = secondLargest;
                secondLargest = temp;
            }
        }
        System.out.println("Second largest element is : "+secondLargest);
    }
}
