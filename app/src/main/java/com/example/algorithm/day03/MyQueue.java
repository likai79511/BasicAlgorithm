package com.example.algorithm.day03;

import com.example.algorithm.day02.DynamicArray;

/**
 * 基于动态数组实现的 队列 Queue
 *
 * 队列： 先进先出，一端添加，另一端取出
 *
 * 时间复杂度分析：
 *
 * {@link this#enqueue} : O(1). 向数组的末尾添加，不需要做移位，数组扩容是复杂度均摊
 * {@link this#dequeue} : O(n). 从数组头部删除，做移位
 * {@link this#getFront} : O(1)
 * {@link this#getSize} : O(1)
 * {@link this#isEmpty} : O(1)
 *
 *
 * @param <E>
 */
public class MyQueue<E> implements Queue<E> {

    private DynamicArray<E> array;

    public MyQueue() {
        array = new DynamicArray<>();
    }

    @Override
    public void enqueue(E value) {
        array.addLast(value);
    }

    @Override
    public E dequeue() {
        return array.remove(0);
    }

    @Override
    public E getFront() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("tail [");

        for (int i = 0; i < array.getSize(); i++) {
            if (i!=array.getSize()-1){
                sb.append(array.get(array.getSize()-i-1)+",");
            }else{
                sb.append(array.get(array.getSize()-i-1));
            }
        }

        sb.append("] head");

        return sb.toString();
    }
}
