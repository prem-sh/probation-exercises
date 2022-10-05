package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;
import java.util.Iterator;

public class FindLength {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,99,999,9999,99999,999999};
        long count = 0;
        for (int a:arr) count++;
        System.out.println("Array length : "+count);
    }
}
