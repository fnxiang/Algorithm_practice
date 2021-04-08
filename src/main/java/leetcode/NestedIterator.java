package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        resolve(nestedList, queue);
    }

    public void resolve(List<NestedInteger> list, Queue<Integer> queue){
        for (NestedInteger value : list){
            if(value.isInteger()){
                queue.add(value.getInteger());
            }else{
                resolve(value.getList(), queue);
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        if(queue.isEmpty()){
            return false;
        }
        return true;
    }
}
