package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,99,999,9999,99999};

        System.out.println("Normal Array   : "+ Arrays.toString(arr));
        for (int i=0; i< arr.length/2; i++ ){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        System.out.println("Reversed Array : "+ Arrays.toString(arr));
    }
}
