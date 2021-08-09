package com.example.algorithm.day01;

import com.example.algorithm.CommonUtils;
import com.example.algorithm.Log;

public class test {

    public static void main(String[] args) {

        Integer data[] = CommonUtils.generateRandomData(100, 10000);
        CommonUtils.e("sort before: "+CommonUtils.toArrayStr(data));
        SelectSearch.sort(data);
        CommonUtils.e("sort after: "+CommonUtils.toArrayStr(data));
        CommonUtils.e("sort check: "+CommonUtils.checkIsOrderData(data));


        Integer data2[] = CommonUtils.generateRandomData(100, 10000);
        CommonUtils.e("sort-Recursive before: "+CommonUtils.toArrayStr(data2));
        SelectSearch.sortRecursive(data2,0);
        CommonUtils.e("sort-Recursive after: "+CommonUtils.toArrayStr(data2));
        CommonUtils.e("sort-Recursive check: "+CommonUtils.checkIsOrderData(data2));
    }
}
