package com.example.algorithm.day03;

/**
 * 循环队列
 * 为了降低 普通队列 出队时候的时间复杂度O(n)
 * <p>
 * 思路：
 * 普通队列 出队时间复杂度为 O(n)：是因为数据头部删除后 会做移位操作，来保证起始位置不为空、数据连续性。
 * <p>
 * 优化思路： 出队不做移位，将头节点指向后移(类似虚拟头节点)，保证head数据不为空 以及 数据连续性， 此时
 * 数组的真实头部是空的（因为出队的原因），为了不浪费这部分空间，如果数组尾部满了时，原本此时需要resize扩容，因为
 * 真实头部还有空间，此时将需要添加的数据加到数组的头部，实现循环队列。 当整个数组全部添加满时，再去resize扩容。
 * <p>
 * 比如：
 * 向队列中push: 1,2,3,4,5 (数组中 尾部添加，头部取。 因为往数组尾部添加时间复杂度O(1)),队列情况如下：
 *
 * |1|2|3|4|5|
 * |       |
 * head    tail
 * 此时头部指向 1, 尾部指向5, 维持了先进先出的原则。
 * <p>
 * ->出队dequeue一次,数组从头部删除
 * 普通队列会变为： |NULL|2|3|4|5|    做移位后-> |2|3|4|5|NULL|   (数组从0后的元素，均向前移位覆盖，所以时间按复杂度O(n))
 *                   |        |                |     |
 *                  head     tail            head   tail
 * <p>
 * 循环队列：|NULL|2|3|4|5|    不做移位，改变head节点指向
 *               |     |
 *              head   tail;
 * <p>
 * ->出队dequeue一次：
 * 循环队列：       |NULL|NULL|3|4|5|
 *                           |   \
 *                          head  tail
 * <p>
 * ->入队 enqueue一次：6
 * 循环队列:    |6|NULL|3|4|5|   此时因为数组尾部已满，但是头部仍有空间，添加到起始位置，tail改变指向
 *              |      |
 *             tail   head
 * <p>
 * 根据head和tail位置，如何判断数组是否已满(需要扩容)、是否为空。
 * <p>
 * ->入队 enqueue一次：7
 * 循环队列:    |6|7|3|4|5|   head指向array[2] = 3, tail指向array[1] = 7
 *               |  \
 *             tail head
 * <p>
 * 根据size和capacity来判断是否为空和为满
 * <p>
 * 数组为空时： size = 0 即可。
 * <p>
 * 数组满时： size = capacity
 * <p>
 * 就比如： |6|7|3|4|5|   head指向array[2] = 3, tail指向array[1] = 7， size = 5, (1 + 1) % 5 = 2 == head
 *            |  \
 *          tail head
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private final int DEFAULT_SIZE = 10;

    private E[] data;

    //当前数组的元素个数，不等于数组的实际大小
    private int size = 0;

    //数组的实际大小
    private int capacity;

    private int head = -1;
    private int tail = -1;

    public LoopQueue() {
        data = (E[]) new Object[DEFAULT_SIZE];
        head = -1;
        tail = -1;
        size = 0;
        capacity = data.length;
    }

    @Override
    public void enqueue(E value) {
        if (isFull()) {
            //容量满了，需要扩容
            resize(capacity * 2);
        }else if (isEmpty()){
            head = 0;
        }
        tail = (tail + 1) % capacity;
        data[tail] = value;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("the queue has been empty!");

        E temp = data[head];
        data[head] = null;
        head = (head + 1) % capacity;
        size--;
        return temp;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("the queue has been empty!");
        return data[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }


    private void resize(int capacity) {
        E[] dataNew = (E[]) new Object[capacity];

        if (tail < head) {
            tail += capacity;
        }
        for (int i = head, j = 0; i <= (tail - head); i++) {
            dataNew[j] = data[i];
            j++;
        }
        head = 0;
        tail = data.length - 1;
        data = dataNew;
        this.capacity = data.length;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("head [");

        if (!isEmpty()){
            if (tail < head)
                tail += capacity;
            for (int i=head,j=0;i<=tail-head;i++){
                if (i!=tail-head){
                    sb.append(data[i]+",");
                }else{
                    sb.append(data[i]);
                }
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
