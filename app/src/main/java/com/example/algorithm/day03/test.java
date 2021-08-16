package com.example.algorithm.day03;

import com.example.algorithm.CommonUtils;

public class test {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        CommonUtils.e(stack.toString());

        stack.push(1);
        CommonUtils.e(stack.toString());

        stack.push(2);
        CommonUtils.e(stack.toString());

        stack.push(3);
        CommonUtils.e(stack.toString());

        stack.push(4);

        stack.push(5);
        CommonUtils.e(stack.toString());

        CommonUtils.e("pop: "+stack.pop()+",result: "+stack.toString());
        CommonUtils.e("pop: "+stack.pop()+",result: "+stack.toString());
        CommonUtils.e("pop: "+stack.pop()+",result: "+stack.toString());
        CommonUtils.e("pop: "+stack.pop()+",result: "+stack.toString());
        CommonUtils.e("pop: "+stack.pop()+",result: "+stack.toString());

    }
}
