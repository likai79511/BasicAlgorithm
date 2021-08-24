package com.example.algorithm.day03;

import com.example.algorithm.CommonUtils;

public class test {
    public static void main(String[] args) {

       /* MyStack<Integer> stack = new MyStack<>();
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

        CommonUtils.e("pop: " + stack.pop() + ",result: " + stack.toString());
        CommonUtils.e("pop: " + stack.pop() + ",result: " + stack.toString());
        CommonUtils.e("pop: " + stack.pop() + ",result: " + stack.toString());
        CommonUtils.e("pop: " + stack.pop() + ",result: " + stack.toString());
        CommonUtils.e("pop: " + stack.pop() + ",result: " + stack.toString());


        CommonUtils.e("=====problem======");

        problem1();


        //Queue
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        CommonUtils.e("enqueue : 1, result: "+queue.toString());
        queue.enqueue(2);
        CommonUtils.e("enqueue : 2, result: "+queue.toString());
        queue.enqueue(3);
        CommonUtils.e("enqueue : 3, result: "+queue.toString());
        queue.enqueue(4);
        CommonUtils.e("enqueue : 4, result: "+queue.toString());

        int value = queue.dequeue();
        CommonUtils.e("dequeue: "+value+", result: "+queue.toString());
        value = queue.dequeue();
        CommonUtils.e("dequeue: "+value+", result: "+queue.toString());
        value = queue.dequeue();
        CommonUtils.e("dequeue: "+value+", result: "+queue.toString());
        value = queue.dequeue();
        CommonUtils.e("dequeue: "+value+", result: "+queue.toString());*/

        //Loop Queue
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        CommonUtils.e(loopQueue.toString());

        loopQueue.enqueue(1);
        CommonUtils.e("enqueue : 1, result: "+loopQueue.toString());
        loopQueue.enqueue(2);
        CommonUtils.e("enqueue : 2, result: "+loopQueue.toString());
        loopQueue.enqueue(3);
        CommonUtils.e("enqueue : 3, result: "+loopQueue.toString());
        loopQueue.enqueue(4);
        CommonUtils.e("enqueue : 4, result: "+loopQueue.toString());

    }

    /**
     * 利用栈解决的一个问题
     * <p>
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static void problem1() {
        String testStr = "{}[]{()}";
        String testStr2 = "{}[]{(])}";

        CommonUtils.e("result-1: " + checkIsMatch(testStr));
        CommonUtils.e("result-2: "+checkIsMatch(testStr2));
    }

    private static boolean checkIsMatch(String content) {
        MyStack<Character> stack = new MyStack<>();

        char top;
        char now;
        for (int i = 0; i < content.length(); i++) {

            now = content.charAt(i);

            if (now == '{' || now == '[' || now == '(') {
                stack.push(now);
            } else {
                if (stack.isEmpty())
                    return false;
                top = stack.pop();
                if (now == '{' && top != '}')
                    return false;
                if (now == '[' && top != ']')
                    return false;
                if (now == '(' && top != ')')
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
