package com.example.algorithm;

import java.util.Random;

public class CommonUtils {

    public static Random mRandom = new Random();

    public static class Singleton {
        public final static CommonUtils instance = new CommonUtils();
    }

    private CommonUtils() {
    }

    public <E> String toArrayStr(E[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                sb.append(i + ",");
            } else {
                sb.append(i);
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
    public static int[] generateRandomData(int size, int max) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = mRandom.nextInt(max);
        }
        return data;
    }

    /**
     * 生成指定长度的有序数组
     *
     * @param size
     * @param desc  是否为降序数组
     * @return
     */
    public static int[] generateOrderData(int size, boolean desc) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = desc ? size - i - 1 : i;
        }
        return data;
    }

}
