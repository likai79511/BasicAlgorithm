package com.example.algorithm.day01;

import com.example.algorithm.CommonUtils;

public class test {

    public static void main(String[] args) {

        Integer data[] = CommonUtils.generateRandomData(100, 10000);
        CommonUtils.e("Select-sort before: "+CommonUtils.toArrayStr(data));
        SelectSort.sort(data);
        CommonUtils.e("Select-sort after: "+CommonUtils.toArrayStr(data));
        CommonUtils.e("Select-sort check: "+CommonUtils.checkIsOrderData(data));


        Integer data2[] = CommonUtils.generateRandomData(100, 10000);
        CommonUtils.e("Select-sort-Recursive before: "+CommonUtils.toArrayStr(data2));
        SelectSort.sortRecursive(data2,0);
        CommonUtils.e("Select-sort-Recursive after: "+CommonUtils.toArrayStr(data2));
        CommonUtils.e("Select-sort-Recursive check: "+CommonUtils.checkIsOrderData(data2));


        Integer data3[] = CommonUtils.generateRandomData(100, 10000);
        CommonUtils.e("Insert-sort before: "+CommonUtils.toArrayStr(data3));
        InsertSort.betterSort(data3);
        CommonUtils.e("Insert-sort after: "+CommonUtils.toArrayStr(data3));
        CommonUtils.e("Insert-sort check: "+CommonUtils.checkIsOrderData(data3));

    }
}
