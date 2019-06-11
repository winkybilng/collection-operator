package com.thoughtworks.collection;

public interface SingleLink<T> {
    void addTailPointer(T item);
    T getNode(int index);
}