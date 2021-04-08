package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No190 {
    public int reverseBits(int n) {
        String ans = "";
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 32; i++) {
            if(((n>>i)&1)==1){
                queue.add(1);
            }else{
                queue.add(0);
            }
        }

        while (!queue.isEmpty()){
            ans+=queue.poll();
        }

        return Integer.parseUnsignedInt(ans, 2);
    }
}
