package io.github.prem_sh.arrays.sorting_algorithms;

import java.util.Comparator;

public class SelectionSort<T extends Comparable<T>> implements SortingAlgorithm<T>{
    @Override
    public void sort(T[] store) {
        int last = findLast(store);
        for (int i=0; i<last; i++){
            for(int j=i; j<=last; j++){
                if(store[i].compareTo(store[j])>0){
                    T temp = store[i];
                    store[i] = store[j];
                    store[j] = temp;
                }
            }
        }
    }
    @Override
    public void sort(T[] store, Comparator<T> comparator) {
        int last = findLast(store);
        for (int i=0; i<last; i++){
            for(int j=i; j<=last; j++){
                if(comparator.compare(store[i],store[j])>0){
                    T temp = store[i];
                    store[i] = store[j];
                    store[j] = temp;
                }
            }
        }
    }

    @Override
    public void sort(T[] store, boolean reversed) {

        int last = findLast(store);

        if(reversed) for (int i=0; i<last; i++){
            for(int j=i; j<=last; j++){
                if(store[i].compareTo(store[j])<0){
                    T temp = store[i];
                    store[i] = store[j];
                    store[j] = temp;
                }
            }
        }
        else sort(store);
    }

    @Override
    public void sort(T[] store, boolean reversed, Comparator<T> comparator) {
        int last = findLast(store);

        if(reversed) for (int i=0; i<last; i++){
            for(int j=i; j<=last; j++){
                if(comparator.compare(store[i],store[j])<0){
                    T temp = store[i];
                    store[i] = store[j];
                    store[j] = temp;
                }
            }
        }
        else sort(store, comparator);
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
