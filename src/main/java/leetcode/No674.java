package leetcode;

class No674 {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int tmp = 1;
        max = nums.length>0?1:0;
        for (int i=1; i<nums.length;i++) {
            if(nums[i]>nums[i-1]) tmp++;
            else tmp =1;
            max = tmp>max?tmp:max;
        }
        return max;
    }
}