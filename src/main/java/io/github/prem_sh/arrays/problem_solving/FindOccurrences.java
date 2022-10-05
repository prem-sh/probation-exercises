package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindOccurrences {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,2,3,1,4,5,1,5,1,6,7,7};
        Map<Integer, Integer> counter = new LinkedHashMap<>();
        Arrays.stream(arr).forEach(n->{
            if(counter.containsKey(n)) counter.put(n, counter.get(n)+1);
            else counter.put(n,1);
        });
        for (Map.Entry e:counter.entrySet()) {
            System.out.println(e.getKey()+" occurs "+e.getValue()+" times");
        }
    }
}
