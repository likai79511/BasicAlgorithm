package com.example.algorithm.day01;

import com.example.algorithm.CommonUtils;
import com.example.algorithm.Log;

public class test {

    public static void main(String[] args) {
        Integer data[] = {1,2,3,4,5,6,9,8,7,5,6};
        int target = 5;

        Log.i("data: %s\ntarget: %s\nresult: %s",
                CommonUtils.Singleton.instance.toArrayStr(data),
                target,
                LinearSearch.search(data,target));

        target = 66;
        Log.i("\ndata: %s\ntarget: %s\nresult: %s",
                CommonUtils.Singleton.instance.toArrayStr(data),
                target,
                LinearSearch.search(data,target));
    }
}
