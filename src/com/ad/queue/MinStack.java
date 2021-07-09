package com.ad.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    private Deque<Integer> minStack;
    private Deque<Integer> xStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.minStack = new LinkedList<>();
        this.xStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        minStack.pop();
        xStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
