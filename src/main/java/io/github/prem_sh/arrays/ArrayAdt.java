package io.github.prem_sh.arrays;

import io.github.prem_sh.arrays.sorting_algorithms.SortingAlgorithm;

public interface ArrayAdt<T extends Comparable<T>>  extends ArrayAdtUtils<T>{
    T[] getArray();
    int length();
    int size();
    void extend();
    void trim();
    void add(T ele);
    T[] insertHead(T ele);
    T[] insertTail(T ele);
    T[] insertHead(T[] arr);
    T[] insertTail(T[] arr);
    T[] insertHead(ArrayAdt<T> arr);
    T[] insertTail(ArrayAdt<T> arr);
    T removeHead();
    T removeTail();
    T[] removeHead(int n);
    T[] removeTail(int n);
    T head();
    T tail();
    T[] head(int n);
    T[] tail(int n);
    T insertAt(int idx, T ele);
    T get(int id);
    T set(int id, T ele);
    void clear();
    T remove(T ele);
    T remove(int idx);
    boolean equals(Object obj);
    String toString();

    void setSortingStrategy(SortingAlgorithm<T> algo);
    String getSortingStrategy();

    static void help() {
        System.out.println("""
                =========[ Help ]=========
                > ArrayAdt is Data Structure to store and do operations on objects.
                > It is generic class which supports all type of comparable objects (implements Comparable)
                > It provides various basic functionalities and utilities.
                
                ----< Basic Methods >-----
                    T[] getArray();
                    int length();
                    int size();
                    void extend();
                    void trim();
                    void add(T ele);
                    T[] insertHead(T ele);
                    T[] insertTail(T ele);
                    T[] insertHead(T[] arr);
                    T[] insertTail(T[] arr);
                    T[] insertHead(ArrayAdt<T> arr);
                    T[] insertTail(ArrayAdt<T> arr);
                    T removeHead();
                    T removeTail();
                    T[] removeHead(int n);
                    T[] removeTail(int n);
                    T head();
                    T tail();
                    T[] head(int n);
                    T[] tail(int n);
                    T insertAt(int idx, T ele);
                    T get(int id);
                    T set(int id, T ele);
                    void clear();
                    T remove(T ele);
                    T remove(int idx);
                    void setComparator(Comparator<T> comparator);
                    boolean equals(Object obj);
                    String toString();
                    
                ----< Utility Methods >-----
                    void rotateRight();
                    void rotateLeft();
                    void swap(int idx1, int idx2);
                    void sort();
                    void sort(int from, int to);
                    void sortFrom(int from);
                    void sortTo(int to);
                    T min();
                    T max();
                    T min(int n);
                    T max(int n);
                    T min(Comparator<T> comparator);
                    T max(Comparator<T> comparator);
                    T min(int nth, Comparator<T> comparator);
                    T max(int nth, Comparator<T> comparator);
                    
                    ArrayAdt<T> filter();
                    ArrayAdt<T> map();
                    void foreach();
                    void print();
                """);
    }
}
