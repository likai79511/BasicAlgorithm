package com.example.algorithm.day02;

import com.example.algorithm.CommonUtils;

public class test {
    public static void main(String[] args) {

        DynamicArray<Integer> array = new DynamicArray<>(5);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        CommonUtils.e(array.toString());

        array.removeLast();
        array.removeLast();
        array.removeLast();
        CommonUtils.e(array.toString());
        array.removeLast();
        CommonUtils.e(array.toString());
        array.removeLast();
        CommonUtils.e(array.toString());
        array.removeLast();
        CommonUtils.e(array.toString());
        array.removeLast();
        CommonUtils.e(array.toString());
        array.removeLast();
        CommonUtils.e(array.toString());
    }
}
