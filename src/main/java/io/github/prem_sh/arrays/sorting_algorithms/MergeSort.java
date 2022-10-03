package io.github.prem_sh.arrays.sorting_algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MergeSort<T extends Comparable<T>> implements SortingAlgorithm<T>{
    @Override
    public void sort(T[] store) {
        sort(store, 0, findLast(store),(a,b)->a.compareTo(b)<=0);
    }

    @Override
    public void sort(T[] store, boolean reverse) {
        if(reverse) sort(store, 0, findLast(store),(a,b)->a.compareTo(b)>=0);
        else sort(store, 0, findLast(store),(a,b)->a.compareTo(b)<=0);
    }

    @Override
    public void sort(T[] store, Comparator<T> comparator) {
        sort(store, 0, findLast(store), (a,b)->comparator.compare(a,b)<=0);
    }

    @Override
    public void sort(T[] store, boolean reverse, Comparator<T> comparator) {
        if (reverse) sort(store, 0, findLast(store),(a,b)->comparator.compare(a,b)<=0);
        else sort(store, 0, findLast(store),(a,b)->comparator.compare(a,b)>=0);
    }

    private void sort(T[] array, int left, int right, BiPredicate<T, T> predicate){
        if(left <= right) {
            int mid = left + (right - left) / 2;
            sort(array, left, mid, predicate);
            sort(array, mid + 1, right, predicate);
            merge(array, left, mid, right, predicate);
        }
    }

    private void merge(T array[], int l, int m, int r, BiPredicate<T, T> predicate) {
        int lenL = m - l + 1;
        int lenR = r - m;

        T left[] = (T[]) new Comparable[lenL];
        T right[] = (T[]) new Comparable[lenR];

        for (int i = 0; i < lenL; i++) left[i] = array[i + l];
        for (int i = 0; i < lenR; i++) right[i] = array[i + m + 1];

        int i = 0, j = 0, k = l;

        while(i<lenL && j<lenR)
            if (predicate.test(left[i], right[j])) array[k++] = left[i++];
            else array[k++] = right[j++];

        while (i < lenL) array[k++] = left[i++];
        while (j < lenR) array[k++] = right[j++];
    }

    private int findLast(T[] store){
        int count = 0;
        while(store.length>count){
            if(store[count]==null){
                break;
            }
            count++;
        }
        return  --count;
    }

}
