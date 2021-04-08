package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No46 {
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        recur(nums.length, sub, nums);
        return new ArrayList<>(set);
    }

    public void recur(int length, List<Integer> list, int[] nums){
        if(list.size()==length){
            set.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < length; i++) {
            if(list.contains(nums[i])) {
                continue;
            }else{
                list.add(nums[i]);
                recur(length, list, nums);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        No46 obj = new No46();
        System.out.println(obj.permute(nums));
    }
}
