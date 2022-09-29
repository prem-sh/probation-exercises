package io.github.prem_sh.arrays.sorting_algorithms;

import java.util.Comparator;

public class InsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T>{
    @Override
    public void sort(T[] store) {
        int last = findLast(store);
        T temp;
        for (int pos = 1; pos<=last; pos++){
            int k = pos;
            for (int j=pos-1; j>=0; j--){
                if(store[j].compareTo(store[k])>0){
                    temp = store[j];
                    store[j] = store[k];
                    store[k] = temp;
                    k=j;
                }
            }
        }

    }

    @Override
    public void sort(T[] store, boolean reverse) {
        int last = findLast(store);
        T temp;
        if (reverse) for (int pos = 1; pos<=last; pos++){
            int k = pos;
            for (int j=pos-1; j>=0; j--){
                if(store[j].compareTo(store[k])<0){
                    temp = store[j];
                    store[j] = store[k];
                    store[k] = temp;
                    k=j;
                }
            }
        } else sort(store);
    }

    @Override
    public void sort(T[] store, Comparator<T> comparator) {
        int last = findLast(store);
        T temp;
        for (int pos = 1; pos<=last; pos++){
            int k = pos;
            for (int j=pos-1; j>=0; j--){
                if(comparator.compare(store[j],store[k])>0){
                    temp = store[j];
                    store[j] = store[k];
                    store[k] = temp;
                    k=j;
                }
            }
        }
    }

    @Override
    public void sort(T[] store, boolean reverse, Comparator<T> comparator) {
        int last = findLast(store);
        T temp;
        if (reverse) for (int pos = 1; pos<=last; pos++){
            int k = pos;
            for (int j=pos-1; j>=0; j--){
                if(comparator.compare(store[j],store[k])<0){
                    temp = store[j];
                    store[j] = store[k];
                    store[k] = temp;
                    k=j;
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
