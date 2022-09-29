package io.github.prem_sh.arrays;

import io.github.prem_sh.arrays.sorting_algorithms.SortingAlgorithm;
import io.github.prem_sh.arrays.sorting_algorithms.SelectionSort;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayAdtImpl<T extends Comparable<T>> implements ArrayAdt<T>{
    private final int DEFAULT_INITIAL_SIZE = 3;
    private T[] store;
    private int last;
    private SortingAlgorithm<T> sortingStrategy;

    public ArrayAdtImpl(){
        this.store = (T[]) new Comparable[DEFAULT_INITIAL_SIZE];
        last = -1;
        sortingStrategy = new SelectionSort<T>();
    }
    public ArrayAdtImpl(int size) {
        this.store = (T[]) new Comparable[size];
        last = -1;
        sortingStrategy = new SelectionSort<T>();
    }
    public ArrayAdtImpl(T... source){
        this.store = source;
        last = source.length-1;
        sortingStrategy = new SelectionSort<T>();
    }
    public ArrayAdtImpl(ArrayAdt<T> source){
        this.store = source.getArray();
        last = source.length()-1;
        sortingStrategy = new SelectionSort<T>();
    }
    @Override
    public void setSortingStrategy(SortingAlgorithm<T> algo){
        this.sortingStrategy = algo;
    }

    @Override
    public String getSortingStrategy(){
        return sortingStrategy.getClass().toString();
    }

    public T[] getArray() {
        return store;
    }

    public int length(){
        return last+1;
    }

    public int size(){
        return store.length;
    }

    public void extend(){
        T[] temp = store;
        store = (T[]) new Comparable[temp.length*2];
        for (int i=0; i<temp.length;i++) {
            store[i] = temp[i];
        }
    }

    public void trim(){
        T[] temp = store;
        store = (T[]) new Comparable[last+1];
        for (int i = 0; i<=last; i++)
            store[i] = temp[i];
    }

    public void add(T ele){
        if(++last >= store.length) this.extend();
        store[last]=ele;
    }

    @Override
    public T[] insertHead(T ele) {
        return null;
    }

    @Override
    public T[] insertTail(T ele) {
        add(ele);
        return store;
    }

    @Override
    public T[] insertHead(T[] arr) {
        return null;
    }

    @Override
    public T[] insertTail(T[] arr) {
        for(int i=0;i<arr.length&&arr[i]!=null;i++){
            this.add(arr[i]);
        }
        return null;
    }

    @Override
    public T[] insertHead(ArrayAdt<T> arr) {
        return null;
    }

    @Override
    public T[] insertTail(ArrayAdt<T> source) {
        T[] arr = source.getArray();
        for(int i=0;i<arr.length&&arr[i]!=null;i++){
            this.add(arr[i]);
        }
        return this.store;
    }

    @Override
    public T removeHead() {
        T temp = store[0];
        for(int i=0; i<last; i++){
            store[i] = store[i+1];
        }
        store[last] = null;
        last--;
        return temp;
    }

    @Override
    public T removeTail() {
        T temp = store[last];
        store[last] = null;
        last--;
        return temp;
    }

    @Override
    public T[] removeHead(int n) {
        T[] temp = (T[]) new Comparable[n];
        for (int i=0; i<n ; i++){
           temp[i] = removeHead();
        }
        return temp;
    }

    @Override
    public T[] removeTail(int n) {
        T[] temp = (T[]) new Comparable[n];
        for (int i=0; i<n ; i++){
            temp[i] = removeTail();
        }
        return temp;
    }

    @Override
    public T head() {
        return store[0];
    }

    @Override
    public T tail() {
        return store[last];
    }

    @Override
    public T[] head(int n) {
        T[] temp = (T[]) new Comparable[n];
        for (int i=0; i<n ; i++){
            temp[i] = removeTail();
        }
        return temp;
    }

    @Override
    public T[] tail(int n) {
        T[] temp = (T[]) new Comparable[n];
        for (int i=n-1; i<=last ; i++){
            temp[i] = get(i);
        }
        return temp;
    }

    @Override
    public T insertAt(int idx, T ele) {
        if(idx>last+1 || idx<0) throw new ArrayIndexOutOfBoundsException();
        else if(idx==last+1) this.insertTail(ele);
        else if(idx==0) this.insertHead(ele);
        else{
            if(last==store.length-1) extend();
            for (int i=idx; i<=last; i++){
                store[i+1]=store[i];
            }
            store[idx] = ele;
            last++;
            print();
        }
        return ele;
    }

    @Override
    public T get(int idx) {
        return store[idx];
    }

    @Override
    public T set(int idx, T ele) {
        store[idx] = ele;
        return ele;
    }

    @Override
    public void clear() {
        this.store = (T[]) new Comparable[DEFAULT_INITIAL_SIZE];
        last = -1;
    }

    @Override
    public T remove(T ele) {
        return null;
    }

    @Override
    public T remove(int idx) {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for(int i=0; i<=last; i++){
            buffer.append(store[i].toString()).append(" -> ");
        }
        return buffer.toString();
    }



    @Override
    public void rotateRight() {
        T lastEle = store[last];
        for (int i=last; i>0; i--){
            store[i]=store[i-1];
        }
        store[0]=lastEle;
    }

    @Override
    public void rotateLeft() {
        T temp = store[0];
        for (int i=0; i<last; i++){
            store[i]=store[i+1];
        }
        store[last]=temp;
    }

    @Override
    public void swap(int idx1, int idx2) {
        T temp = store[idx1];
        store[idx1] = store[idx2];
        store[idx2] = temp;
    }

    @Override
    public void sort() {
       sortingStrategy.sort(store);
    }
    @Override
    public void sort(Comparator<T> comparator) {
        sortingStrategy.sort(store, comparator);
    }

    @Override
    public void sort(boolean reversed) {
        sortingStrategy.sort(store, reversed);
    }

    @Override
    public void sort(boolean reversed, Comparator<T> comparator) {
        sortingStrategy.sort(store, reversed, comparator);
    }


    @Override
    public T min() {
        if(last == -1) return null;
        T smallest = store[0];
        for(int i=0; i<=last; i++)
            if(smallest.compareTo(store[i])>0)
                smallest = store[i];
        return smallest;
    }

    @Override
    public T max() {
        if(last == -1) return null;
        T largest = store[0];
        for(int i=0; i<=last; i++)
            if(largest.compareTo(store[i])<0)
                largest = store[i];
        return largest;
    }

    @Override
    public T min(int n) {
        n--;
        if(last == -1) return null;
        if(n>last || n < 0) return null;
        ArrayAdtImpl<T> temp = new ArrayAdtImpl<>(this);
        temp.sort();
        return temp.get(n);
    }

    @Override
    public T max(int n) {
        n--;
        if(last == -1) return null;
        if(n>last || n < 0) return null;
        ArrayAdtImpl<T> temp = new ArrayAdtImpl<>(this);
        temp.sort(true);
        return temp.get(n);
    }

    @Override
    public T min(Comparator<T> comparator) {
        if(last == -1) return null;
        T smallest = store[0];
        for(int i=0; i<=last; i++)
            if(comparator.compare(smallest,store[i])>0)
                smallest = store[i];
        return smallest;
    }

    @Override
    public T max(Comparator<T> comparator) {
        if(last == -1) return null;
        T largest = store[0];
        for(int i=0; i<=last; i++)
            if(comparator.compare(largest,store[i])<0)
                largest = store[i];
        return largest;
    }

    @Override
    public T min(int nth, Comparator<T> comparator) {
        nth--;
        if(last == -1) return null;
        if(nth>last || nth < 0) return null;
        ArrayAdtImpl<T> temp = new ArrayAdtImpl<>(this);
        temp.sort(comparator);
        return temp.get(nth);
    }

    @Override
    public T max(int nth, Comparator<T> comparator) {
        nth--;
        if(last == -1) return null;
        if(nth>last || nth < 0) return null;
        ArrayAdtImpl<T> temp = new ArrayAdtImpl<>(this);
        temp.sort(true, comparator);
        return temp.get(nth);
    }

    @Override
    public ArrayAdt<T> filter() {
        return null;
    }

    @Override
    public ArrayAdt<T> map() {
        return null;
    }

    @Override
    public void foreach() {

    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(this.store));
    }
}
