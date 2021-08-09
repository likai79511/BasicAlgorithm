package com.example.algorithm;

import java.util.Random;

public class CommonUtils {

    public static Random mRandom = new Random();

    public static <E> String toArrayStr(E[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                sb.append(array[i] + ",");
            } else {
                sb.append(array[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 生成指定长度的随机数据
     *
     * @param size
     * @param max
     * @return
     */
    public static Integer[] generateRandomData(int size, int max) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = mRandom.nextInt(max);
        }
        return data;
    }

    /**
     * 生成指定长度的有序数组
     *
     * @param size
     * @param desc 是否为降序数组
     * @return
     */
    public static Integer[] generateOrderData(int size, boolean desc) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = desc ? size - i - 1 : i;
        }
        return data;
    }

    public static <E extends Comparable<E>> boolean checkIsOrderData(E[] data) {
        if (data == null || data.length == 0)
            return true;

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].compareTo(data[i + 1]) > 0)
                return false;
        }
        return true;
    }

    public static <E> void swap(E[] data, int index, int index2) {
        E temp = data[index];
        data[index] = data[index2];
        data[index2] = temp;
    }

    public static void e(String msg) {
        System.out.println(msg);
    }
}
