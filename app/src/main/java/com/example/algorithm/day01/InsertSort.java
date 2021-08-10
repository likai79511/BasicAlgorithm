package com.example.algorithm.day01;

import com.example.algorithm.CommonUtils;

/**
 * 插入排序发 【排序】
 * <p>
 * 思路：
 * 第i个元素，和它前面的数据做比较： 如果小于前面的数据，就进行交换位置，一直比到第0个元素
 * 如果大于前面的数据，就原位不同（即当前位置就是要插入的位置），i+1后进行下一次循环。
 * <p>
 * 例如： 6,4,2,3,1,5
 * <p>
 * 因为第0位置前面没有数据，所以从i=1 即第2号数据开始比较，减少一次循环。
 * <p>
 * loop-1: i=1,元素{4} 和 6比较，因为4<6，所以交换位置，此时遍历已到第0位元素，所以停止循环，结果为 {4,6,2,3,1,5}
 * loop-2: i=2,元素{2} 和 6比较,交换位置，结果为 {4,2,6,3,1,5},因为{2}前还有数据，继续进行比较，2<4,继续交换位置，
 * 结果为{2,4,6,3,1,5}，此时已遍历到第0号元素，停止循环。
 * loop-3: i=3,元素{3}, 第一次交换结果为： {2,4,3,6,1,5}
 *                     第二次交换结果为：{2,3,4,6,1,5}
 *                     第三次比较，因为3>=2，所以不做交换，此时已遍历到第0号元素，停止循环。 结果为：{2,3,4,6,1,5}
 * loop-4: i=4,元素{1}, 第一次：  {2,3,4,1,6,5}
 *                      ...     {2,3,1,4,6,5}
 *                      ...     {2,1,3,4,6,5}
 *                      ...     {1,2,3,4,6,5}
 * loop-5: i=5,元素{5}, 第一次:  {1,2,3,4,5,6}
 *                     第二次：因为5>=4,所以停止循环。 结果为: {1,2,3,4,5,6}
 * <p>
 * 特点： 执行i次循环后，[0-i]将为有序，[i+1,n) 无序。
 *       在和前面的数据比较时，如果有比他大的，进行交换然后继续向前比较，直至遇到比他小的 或者 比到第0号元素，停止。
 *       有n个数据的组，要进行n次遍历，每一次结束后： [0-i]有序，这n次遍历的停止条件：已遍历到第0号元素、前面的数据比它小。
 * <p>
 * 和选择排序的 共同点： 执行i次循环后，[0-i]将为有序，[i+1,n) 无序。
 *            不同点： 选择排序是和后面的数据进行比较，来选出一个最小值。 而 插入排序，是和前面的值比较，来确定插入位置。
 *                    选择排序的插入位置 永远是i+1, 而 插入排序则不定，在[0,i]这个范围。
 * <p>
 * 时间复杂度分析：
 *              对于大小为n的数组，进行n轮循环，每次循环内部遍历： 0,1,2,...n
 *              所以时间复杂度为： O(n^2)
 * 因为插入排序的特点：遇到比自己小的就立刻停止循环。 所以 如果是一个 有序数据的话，时间复杂度将为 O(n)
 * 因为这个特点，它就比 选择排序 效率要高，虽然时间复杂度都一样。
 */
public class InsertSort {

    /**
     * 非递归实现、原地排序
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] data) {

        if (data == null || data.length == 0)
            return;

        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    CommonUtils.swap(data, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 一种 插入排序发的 优化思路
     * 因为插入排序： 一旦发现 当前i数据 比 前面数据小的时候，就会发生swap，而swap里面包含了三步操作：临时变量，2次赋值
     * 优化思路： 暂存第i数据， 如果遇到比 前面的数据小的时候， 前面的数据直接 平移/覆盖 第i元素，最终我们把暂存的i元素的值
     * 覆盖到最终位置上去。
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void betterSort(E[] data) {
        if (data == null || data.length == 0)
            return;

        E temp;
        int index;

        for (int i = 1; i < data.length; i++) {
            index = i;
            temp = data[i];
            for (int j = i; j > 0; j--) {
                if (temp.compareTo(data[j - 1]) < 0) {
                    data[j] = data[j - 1];
                    index = j - 1;
                } else {
                    break;
                }
            }
            data[index] = temp;
        }
    }
}
