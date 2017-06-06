package com.example.fundamental;

import java.util.LinkedList;

/**
 * Created by PC on 2017/6/5.
 */

public class Queue {
    //使用链表实现队列
    private LinkedList queue = new LinkedList();
    // 入队列
    public void enQueue(Object o)
    {
        queue.addLast(o);
    }
    //出队列
    public Object deQueue()
    {
        return queue.removeFirst();
    }
    //判断队列是否为空
    public boolean isQueueEmpty()
    {
        return queue.isEmpty();
    }
    //判断队列是否包含o
    public boolean isContains(Object o)
    {
        return queue.contains(o);
    }

}
