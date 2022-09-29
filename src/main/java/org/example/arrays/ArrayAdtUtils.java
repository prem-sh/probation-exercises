package org.example.arrays;

import java.util.Comparator;

public interface ArrayAdtUtils<T extends Comparable<T>> {
    void rotateRight();
    void rotateLeft();
    void swap(int idx1, int idx2);
    void sort();
    void sort(Comparator<T> comparator);
    void sort(boolean reversed);
    void sort(boolean reversed, Comparator<T> comparator);
    T min();
    T max();
    T min(int n);
    T max(int n);
    T min(Comparator<T> comparator);
    T max(Comparator<T> comparator);
    T min(int nth, Comparator<T> comparator);
    T max(int nth, Comparator<T> comparator);
    void union(ArrayAdt<T> arr);
    void intersect(ArrayAdt<T> arr);
    boolean hasAll(ArrayAdt<T> arr);
    void retainAll(ArrayAdt<T> arr);
    void removeAll(ArrayAdt<T> arr);
    ArrayAdt<T> filter();
    ArrayAdt<T> map();
    void foreach();
    void print();
}
