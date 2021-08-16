package com.example.algorithm.day03;

import com.example.algorithm.day02.DynamicArray;

/**
 * 使用day02中 的 动态数组 {@link DynamicArray} 来实现栈。
 * 只要保证添加和取出在一端进行即可，所以是往数组的0元素添加 还是 size元素添加，都可以，只要保证获取位置匹配就可以。
 * 此处采用【向数组末尾添加和获取】，因为这样时间复杂度最低。
 *
 * 时间复杂度分析（向数组末尾添加和获取 的实现）：
 * {@link #push} O(1),如果遇到数组扩容，均摊复杂度也可以说是O(1)
 * {@link #pop} O(1)
 * {@link #top} O(1)
 *
 * 时间复杂度分析（向数组0位置 添加和获取 的实现）：
 * {@link #push} O(n),因为要移位。
 * {@link #pop} O(n),因为要移位。
 * {@link #top} O(1)
 *
 * @param <E>
 */
public class MyStack<E> implements Stack<E> {

    private DynamicArray<E> array;

    public MyStack() {
        array = new DynamicArray<>();
    }

    @Override
    public void push(E value) {
        array.addLast(value);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E top() {
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

        if (isEmpty()){
            return "top[ ]bottom";
        }

        StringBuffer sb = new StringBuffer();

        sb.append("top[ ");

        for (int i = 0; i < getSize(); i++) {
            if (i < getSize() - 1) {
                sb.append(array.get(getSize()-i-1) + ",");
            }else{
                sb.append(array.get(getSize()-i-1) + " ] bottom");
            }
        }
        return sb.toString();
    }
}
