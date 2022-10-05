package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {};
        boolean exit = false;
        while(!exit){
            System.out.print("Enter comma seperated intgers : ");
            String[] temp = sc.next().split(",");
            int[] tempInt = new int[temp.length];
            for (int i=0; i<temp.length; i++) tempInt[i]=Integer.parseInt(temp[i]);
            int[] combinedArr = new int[tempInt.length+ arr.length];
            for (int i = 0; i < arr.length; i++) {
                combinedArr[i] = arr[i];
            }
            for (int i = arr.length; i < arr.length+tempInt.length; i++) {
                combinedArr[i] = tempInt[i- arr.length];
            }
            arr = combinedArr;
            System.out.println("Current Array : "+Arrays.toString(arr));
            System.out.print("Do you want to merge more ? (Yes/other) : ");
            String choice = sc.next();
            if(! choice.equalsIgnoreCase("yes")) exit = true;
        }
    }
}
