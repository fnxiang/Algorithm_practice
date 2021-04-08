package com.fring.stack;

import java.util.Stack;

public class CQueue {
    Stack<Integer> push_stack;
    Stack<Integer> pop_stack;
    public CQueue() {
        push_stack = new Stack<>();
        pop_stack = new Stack<>();
    }

    public void appendTail(int value) {
        push_stack.push(value);
    }

    public int deleteHead() {
        if(!pop_stack.isEmpty()) return pop_stack.pop();
        if(pop_stack.isEmpty()&&!push_stack.isEmpty()){
            while (!push_stack.isEmpty()){
                pop_stack.push(push_stack.pop());
            }
            return pop_stack.pop();
        }
        return -1;
    }
}
