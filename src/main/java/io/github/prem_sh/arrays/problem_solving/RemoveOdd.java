package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;

public class RemoveOdd {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,99,999,9999,99999};

        System.out.println("Initial Array state : "+ Arrays.toString(arr));
        for (int i=0; i< arr.length; i++ ){
            if (arr[i]%2==1) {
                remove(i, arr);
                i--;
            }
        }
        System.out.println("Odd numbers removed : "+ Arrays.toString(arr));
    }
    private static void remove(int idx, int[] arr){
        arr[idx] = 0;
        for (int i = idx; i < arr.length-1; i++) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }
}
