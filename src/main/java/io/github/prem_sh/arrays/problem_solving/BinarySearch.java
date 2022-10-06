package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9,99,999,9999,99999};
        System.out.println("Array : "+ Arrays.toString(arr));
        System.out.print("Enter integer to search : ");
        int search = sc.nextInt();
        int index = bSearch(arr, 0, arr.length-1, search);
        if(index>=0) System.out.println("Found at index : "+index);
        else System.out.println("Not found !");
    }
    public static int bSearch(int[] arr, int start, int end, int arg){
        int mid = (start+end)/2;
        if (arr[mid]>arg){
            return bSearch(arr, start, mid-1, arg);
        } else if (arr[mid]<arg) {
            return bSearch(arr, mid+1, end, arg);
        } else return mid;
    }
}
