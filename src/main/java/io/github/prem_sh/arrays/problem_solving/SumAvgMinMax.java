package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;

public class SumAvgMinMax {
    public static void main(String[] args) {
        long[] arr = {1,2,3,4,5,6,7,8,9,99,999,9999,99999,999999};
        long count = 0;
        long sum = 0;
        long avg = 0;
        long min = arr[0];
        long max = arr[0];
        for (long i : arr) {
            sum+=i;
            count++;
            if(max<i) max = i;
            if(min>i) min = i;
        }
        avg = sum/count;
        System.out.println("Input Array : "+ Arrays.toString(arr));
        System.out.println("""
                Minimum  : %d
                Maximum  : %d
                Average  : %d
                Sumation : %d
                """.formatted(min, max, avg, sum)
        );
    }
}
