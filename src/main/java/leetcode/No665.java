package leetcode;

import java.util.HashSet;
import java.util.Set;

public class No665 {
    public boolean checkPossibility(int[] nums) {
        HashSet<Integer> index_set = new HashSet<Integer>();

        for (int i=1;i<nums.length;i++){
            for (int j=0;j<nums.length-i;j++){
                if(nums[j]>nums[j+i]&&!index_set.contains(j)){
                    index_set.add(j);
                    }
                }
        }

        if(index_set.size()>1) return false;
        else return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = 5;
        nums[1] = 7;
        nums[2] = 1;
        nums[3] = 8;
        No665 obj = new No665();
        obj.checkPossibility(nums);
    }
}
