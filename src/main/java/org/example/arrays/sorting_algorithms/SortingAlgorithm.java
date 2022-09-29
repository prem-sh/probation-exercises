package org.example.arrays.sorting_algorithms;

import java.util.Comparator;

public interface SortingAlgorithm<T>{
    void sort(T[] store);
    void sort(T[] store, boolean reverse);
    void sort(T[] store, Comparator<T> comparator);
    void sort(T[] store, boolean reverse, Comparator<T> comparator);
}
