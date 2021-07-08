package com.ad.queue;

/**
 * 622. 设计循环队列
 * https://leetcode-cn.com/problems/design-circular-queue/
 */
class MyCircularQueue {

    //生命栈的大小
    private int capacity;
    //存储元素
    private int[] data;

    private int count;

    private int headIndex;

    public MyCircularQueue(int k) {

        this.capacity = k;
        this.data = new int[capacity];
        this.headIndex = 0;
        this.count = 0;
    }

    //入栈,向循环队列插入一个元素。如果成功插入则返回真
    public boolean enQueue(int value) {
        //存储元素和容量相等，栈已满，不能存储元素
        if (this.count == this.capacity) {
            return false;
        }

        //[0,0,0,1,1,0,0] capacity = 7, headerIndex = 4 count=2
        this.data[(this.headIndex+this.count) % this.capacity] = value;
        this.count+=1;
        return true;
    }

    // 从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {

        if (this.count == 0) {
            return false;
        }

        this.headIndex = (this.headIndex+1)%this.capacity;
        this.count -= 1;

        return true;
    }

    //从队首获取元素。如果队列为空，返回 -1
    public int Front() {

        if (this.count <= 0) {
            return -1;
        }

        return this.data[this.headIndex];
    }

    //获取队尾元素。如果队列为空，返回 -1
    public int Rear() {

        if (this.count <= 0) {
            return -1;
        }

        int tailIndex = (this.headIndex+this.count-1)%capacity;
        return this.data[tailIndex];
    }

    //检查循环队列是否为空
    public boolean isEmpty() {

        return this.count == 0;
    }

    //检查循环队列是否已满
    public boolean isFull() {

        return (this.count == this.capacity);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
