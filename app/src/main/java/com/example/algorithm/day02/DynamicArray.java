package com.example.algorithm.day02;

import com.example.algorithm.CommonUtils;

/**
 * 动态数组 [java数组封装，实现动态扩容]
 * <p>
 * 时间复杂度分析：
 * <p>
 * <p>
 * 增加元素:
 * {@link #addLast}: 只需要添加到尾部，所以时间复杂度为O(1)
 * {@link #add}: 需要添加到制定位置，O(n)
 * 因为扩容{@link #resize} 并非每次都会触发，所以可以均摊复杂度。
 *
 * <p>
 * 删除元素：
 * {@link #removeLast}: 只需要删除尾部，所以时间复杂度为O(1)
 * {@link #remove}: 只需要删除指定位置，之后数据向前平移，以时间复杂度为O(n)
 * <p>
 * 修改元素：O(1)
 * {@link #update}: O(1)
 * <p>
 * 查询元素: 线性遍历
 * {@link #get}: O(n)
 *
 * @param <E>
 */
public class DynamicArray<E> {

    private int capacity = 20;

    private E[] data;

    //当前数组已存数据个数
    private int size = 0;

    //扩容系数
    private final float resizeScale = 1.5f;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    public DynamicArray() {
        data = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public void add(int index, E value) {
        if (size >= capacity) {
            //容量不足，需要动态扩容
            resize((int) (capacity * resizeScale));
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    public void addLast(E value) {
        if (size >= capacity) {
            //容量不足，需要动态扩容
            resize((int) (capacity * resizeScale));
        }
        data[size] = value;
        size++;
    }

    public void addFirst(E value){
        add(0,value);
    }


    public E removeLast() {

        if (size <= 0) {
            throw new IllegalArgumentException("the array has been empty");
        }
        size--;
        E temp = data[size];
        data[size] = null;

        //检查是否需要缩容
        if (size <= capacity / 3 && capacity / 2 != 0) {
            resize(capacity / 2);
        }

        return temp;
    }

    public E remove(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("out of bounds");
        }
        E temp = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        //检查是否需要缩容
        if (size <= capacity / 3 && capacity / 2 != 0) {
            resize(capacity / 2);
        }
        return temp;
    }

    public E get(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("out of bounds");
        }
        return data[index];
    }

    public E getLast(){
        if (size==0){
            throw new IllegalArgumentException("the array is empty");
        }
        return data[size];
    }

    public int getSize(){
        return size;
    }

    public void update(int index, E value) {
        if (index >= size) {
            throw new IllegalArgumentException("out of bounds");
        }
        data[index] = value;
    }


    private void resize(int capacity) {
        E[] dataNew = (E[]) new Object[capacity];
        System.arraycopy(data, 0, dataNew, 0, size);
        data = dataNew;
        this.capacity = data.length;
    }


    @Override
    public String toString() {
        return CommonUtils.toArrayStr(data);
    }
}
