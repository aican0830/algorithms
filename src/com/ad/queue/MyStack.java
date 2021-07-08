package com.ad.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
class MyStack {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    /** 将元素 x 压入栈顶。*/
    //q1 -> 1
    //q2 -> 1
    public void push(int x) {

        queue2.offer(x); //入队

        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    /** 移除并返回栈顶元素*/
    public int pop() {

        return queue1.poll();
    }

    /** Get the top element. */
    /** 返回栈顶元素 */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    /** 如果栈是空的，返回 true ；否则，返回 false 。*/
    public boolean empty() {

        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */