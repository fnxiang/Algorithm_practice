package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No456 {
    public boolean find132patternAdvanced(int[] nums) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n-1; i >= 0; i--) {
            if(nums[i]<k) return true;
            while(!dq.isEmpty()&&dq.peekLast()<nums[i]){
                k = Math.max(k, dq.pollLast());
            }
            dq.add(nums[i]);
        }
        return false;
    }

    /** 时间复杂度O(n2)*/
    public boolean find132pattern(int[] nums) {
        int min = 0, large = 0;
        boolean find = false;
        for (int i = 0; i < nums.length; i++) {
            min = nums[i];
            find = false;
            for (int j = i+1; j < nums.length; j++) {
                if (min<nums[j]&&!find) {
                    find=true;
                    large = nums[j];
                }else if(find&&large>nums[j]&&nums[j]>min){
                    return true;
                }else if(find){
                    large =large<nums[j]?nums[j]:large;
                }
            }
        }
        return false;
    }
}
