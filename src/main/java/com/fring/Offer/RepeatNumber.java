package com.fring.Offer;

import java.util.HashSet;

public class RepeatNumber {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int val: nums) {
            if(set.contains(val)) return val;
            else set.add(val);
        }
        return 0;
    }
}
