package io.github.prem_sh.arrays.sorting_algorithms;

import java.util.Arrays;
import java.util.Comparator;
//TODO not implemented completely
public class HeapSort<T extends Comparable<T>> implements SortingAlgorithm<T>{
    @Override
    public void sort(T[] store) {
        heapSort(store);
    }

    @Override
    public void sort(T[] store, boolean reverse) {
    }

    @Override
    public void sort(T[] store, Comparator<T> comparator) {

    }

    @Override
    public void sort(T[] store, boolean reverse, Comparator<T> comparator) {

    }

    public void heapSort(T arr[]){
        int n = findLast(arr)+1;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(T arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l].compareTo(arr[largest])>0)
            largest = l;

        if (r < n && arr[r].compareTo(arr[largest])>0)
            largest = r;

        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
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

    public static void main(String[] args) {
        Integer[] arr = {33,100,60,59,4,23,45,99};
        HeapSort<Integer> hs = new HeapSort<>();
        System.out.println(Arrays.toString(arr));
        hs.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
