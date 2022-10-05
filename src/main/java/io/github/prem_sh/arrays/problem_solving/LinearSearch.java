package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9,99,999,9999,99999};
        System.out.println("Array : "+ Arrays.toString(arr));
        System.out.print("Enter integer to search : ");
        int search = sc.nextInt();
        int index = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==search) {
                index = i;
                break;
            }
        }
        if(index>=0) System.out.println("Found at index : "+index);
        else System.out.println("Not found !");
}
}
