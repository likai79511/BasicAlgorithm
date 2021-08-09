package com.example.algorithm.day01;

import com.example.algorithm.CommonUtils;

/**
 * 选择排序法 【排序】
 * 思路：
 * 1.先把最小的拿出来
 * 2.再把剩下的数据中最小的拿出来（递归这个动作）
 * <p>
 * 例如： 6,4,2,3,1,5
 * <p>
 * loop-1: 取出最小数据1, 剩余数据 6,4,2,3,5  组成新数组 {1}
 * loop-2: 取出最小数据2, 剩余数据 6,4,3,5    组成新数据 {1,2}
 * loop-3: 取出最小数据3, 剩余数据 6,4,5      组成新数据 {1,2,3}
 * loop-4: 取出最小数据4, 剩余数据 6,5        组成新数据 {1,2,3,4}
 * loop-5: 取出最小数据5, 剩余数据 6         组成新数据 {1,2,3,4,5}
 * loop-6: 取出最小数据6, 剩余数据 {}        组成新数据 {1,2,3,4,5,6}
 * <p>
 * 时间复杂度分析:
 * 1.每次取最小数据：执行的查询次数依次为 n,n-1,n-2 ... 1, 所以单次取最小数据时间复杂度为O(n)
 * 2.获取最小数据的次数：n次
 * 最终时间复杂度为： O(n^2)
 * <p>
 * 注意：
 * 1.组成新的数组时，也存在遍历（因为要往最后面插入）。因为常数系数会在数据量不断增大时，对性能影响相对指数级来说
 * 可以忽略不计，所以时间复杂度只在指数级才会保留，O(2n),最终消除常数项，所以单次取出和组成新数据为O(n)。
 * 2.在组成新数据时，如果采用 非原地排序，会浪费空间。
 * 原地排序：不会新开辟空间，只在原始数组上操作（交换位置）。
 * 3.递归方式： 一定要注意停止条件。
 * 递归能够让思路更清晰，但同时也会极大增加方法入栈。 使用须谨慎，小心stackoverflow.
 */
public class SelectSearch {

    /**
     * 一种 原地排序 的实现思路 (非递归实现)：
     * 每遍历一次，排好一个数据，和前面已排好数据的index+1做交换。保证每遍历一次,前index的数据均为有序。
     * 每次 arr(i,n)为排序，arr[0,i] 排好序
     * <p>
     * 并非采用冒泡的方式每一次比较就交换，如果遇到小于比较数的暂时先赋值，遍历完成之后在做交换。
     * 因为冒泡的交换会很频繁，而且一次swap会涉及3步动作：临时变量，两次赋值。
     *
     * @param data
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> void sort(E[] data) {

        if (data == null || data.length == 0)
            return;

        int minIndex;

        for (int i = 0; i < data.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (i != minIndex)
                CommonUtils.swap(data, i, minIndex);
        }
        return;
    }

    /**
     * 递归方式实现
     * @param data
     * @param start
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortRecursive(E[] data, int start) {

        if (start >= data.length - 1)
            return;

        int minIndex = start;
        for (int i = start + 1; i < data.length; i++) {
            if (data[i].compareTo(data[minIndex]) < 0) {
                minIndex = i;
            }
        }
        if (minIndex != start) {
            CommonUtils.swap(data, minIndex, start);
        }
        sortRecursive(data, start + 1);
    }
}
