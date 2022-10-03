package io.github.prem_sh.arrays.sorting_algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;

public class QuickSort<T extends Comparable<T>> implements SortingAlgorithm<T>{
    @Override
    public void sort(T[] store) {
        quickSort(store, 0, findLast(store), (a,b)->a.compareTo(b)<0);
    }

    @Override
    public void sort(T[] store, boolean reverse) {
        if(reverse) quickSort(store, 0, findLast(store), (a,b)->a.compareTo(b)>0);
        else quickSort(store, 0, findLast(store), (a,b)->a.compareTo(b)<0);
    }

    @Override
    public void sort(T[] store, Comparator<T> comparator) {
        quickSort(store,0, findLast(store), (a,b)->comparator.compare(a,b)<0);
    }

    @Override
    public void sort(T[] store, boolean reverse, Comparator<T> comparator) {
        if(reverse) quickSort(store,0, findLast(store), (a,b)->comparator.compare(a,b)<0);
        quickSort(store,0, findLast(store), (a,b)->comparator.compare(a,b)>0);
    }

    public void quickSort(T[] array, int left, int right, BiPredicate<T,T> predicate){
        if(left < right){
            int index = partition(array, left, right, predicate);
            quickSort(array, left, index-1, predicate);
            quickSort(array, index+1, right, predicate);
        }
    }
    public int partition(T[] array, int left, int right, BiPredicate<T,T> predicate){
        T pivot = array[right];
        int i = (left - 1);
        for (int j = left; j < right; j++) {
            if (predicate.test(array[j],pivot)) {
                i++;
                T temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        T temp = array[right];
        array[right] = array[i+1];
        array[i+1] = temp;
        return (i + 1);
    }

    public static void main(String[] args) {
        Integer[] arr = {33,100,60,59,4,23,45,99};
        QuickSort<Integer> qs = new QuickSort<>();
        System.out.println(Arrays.toString(arr));
        qs.quickSort(arr, 0, qs.findLast(arr), (a,b)->a.compareTo(b)<0);
        System.out.println(Arrays.toString(arr));
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
