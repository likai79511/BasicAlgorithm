package com.example.algorithm.day01;

/**
 * 线性查找法 【查找】
 * 思路：从第一个元素开始遍历比较，直到找到目标元素后停止动作。
 * 查询速度和目标所在index有关： 如果目标所在index=0,查询的时间复杂度为O(1)， 如果index为
 * size-1， 则时间复杂度为O(n).
 * 时间复杂度分析按照最差的情况计算（上界），所以时间复杂度为 O(n)
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
