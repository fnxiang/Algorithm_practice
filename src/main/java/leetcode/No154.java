package leetcode;

/** 4-9 leetcode 题*/
/** 寻找旋转数组中的最小值，会有重复的数字出现，先剔除数组头和尾一样的数字， 然后采用二分法去寻找旋转点*/
public class No154 {
    public int findMin(int[] nums) {
        int length = nums.length;
        int l = 0;
        int r = length-1;
        while(l<r&&nums[0]==nums[r]) r--;
        while(l<r){
            int mid = (l+r+1)/2;
            /** 判断是否旋转成了二段数组 */
            if(nums[0]<=nums[mid]){
                l = mid;
            }else{
                r=mid-1;
            }
        }
        return r<length-1?nums[r+1]:nums[0];
    }
}
