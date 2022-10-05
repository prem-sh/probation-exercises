package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        long[] arr = {1,2,3,4,5,6,7,8,9};
        long[] arr2 = {1,1,1,1,1,1,1,1,1};
        long[] result = new long[arr.length];
        int idx = 0;
        for (long l:arr) {
            result[idx] = arr[idx]+arr2[idx++];
        }
        System.out.println(Arrays.toString(result));
    }
}
