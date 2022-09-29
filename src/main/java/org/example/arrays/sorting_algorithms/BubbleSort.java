package org.example.arrays.sorting_algorithms;

import java.util.Comparator;

public class BubbleSort<T extends Comparable<T>> implements SortingAlgorithm<T>{
    @Override
    public void sort(T[] store) {
        int last = findLast(store);
        T temp;
        for (int i=0; i<=last; i++){
            for (int j=1; j<=(last-i); j++){
                if(store[j-1].compareTo(store[j])>0){
                    temp = store[j-1];
                    store[j-1] = store[j];
                    store[j] = temp;
                }
            }
        }
    }

    @Override
    public void sort(T[] store, boolean reverse) {
        int last = findLast(store);
        T temp;
        if(reverse) for (int i=0; i<=last; i++){
            for (int j=1; j<=(last-i); j++){
                if(store[j-1].compareTo(store[j])<0){
                    temp = store[j-1];
                    store[j-1] = store[j];
                    store[j] = temp;
                }
            }
        }
        else sort(store);
    }

    @Override
    public void sort(T[] store, Comparator<T> comparator) {
        int last = findLast(store);
        T temp;
        for (int i=0; i<=last; i++){
            for (int j=1; j<=(last-i); j++){
                if(comparator.compare(store[j-1],store[j])>0){
                    temp = store[j-1];
                    store[j-1] = store[j];
                    store[j] = temp;
                }
            }
        }
    }

    @Override
    public void sort(T[] store, boolean reverse, Comparator<T> comparator) {
        int last = findLast(store);
        T temp;
        if(reverse) for (int i=0; i<=last; i++){
            for (int j=1; j<=(last-i); j++){
                if(comparator.compare(store[j-1],store[j])<0){
                    temp = store[j-1];
                    store[j-1] = store[j];
                    store[j] = temp;
                }
            }
        }else sort(store, comparator);
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
