package com.example.algorithm.day01;

/**
 * 线性查找法
 */
public class LinearSearch {

    private LinearSearch(){}

    /**
     * 在给定数组中 查找 指定的元素，找到返回索引，否则返回 -1
     * @param data  给定数组
     * @param target 要查找的目标值
     * @return
     */
    public static <E> int search(E[] data,E target){
        for (int i=0;i<data.length;i++){
            if (data[i].equals(target))
                return i;
        }
        return -1;
    }

}
