package io.github.prem_sh.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetExperiment {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList("Tea", "Coffee", "Coffee", "Lemon Tea", "Lemon Tea", "Masala Tea"));
        System.out.println(set);
    }
}
