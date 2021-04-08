package com.fring.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_s;
    int tmp=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min_s = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min_s.isEmpty()||x<=tmp) {
            tmp=x;
        }
        stack.push(tmp);
    }

    public void pop() {
        stack.pop();
        if(min_s.pop()==tmp) tmp=min_s.isEmpty()?Integer.MAX_VALUE:min_s.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min_s.peek();
    }
}
