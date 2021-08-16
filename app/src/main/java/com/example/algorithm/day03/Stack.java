package com.example.algorithm.day03;

public interface Stack<E> {

    void push(E value);

    E pop();

    E top();

    int getSize();

    boolean isEmpty();
}
