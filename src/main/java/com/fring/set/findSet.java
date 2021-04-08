package com.fring.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findSet {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        find(0, list, nums);
        return new ArrayList<>(ans);
    }

    public void find(int index, List<Integer> set, int[] nums){
        if(index==nums.length) return;
        ans.add(new ArrayList<>(set));
        set.add(nums[index]);
        find(index+1, set, nums);
        set.remove(set.size()-1);
        find(index+1, set, nums);
    }
}
