package com.example.algorithm.day03;

public interface Queue<E> {

    void enqueue(E value);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
