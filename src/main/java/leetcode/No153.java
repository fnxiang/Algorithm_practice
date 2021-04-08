package leetcode;

public class No153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = (l+r+1)/2;
            /** 该方法寻找旋转点*/
            if(nums[mid]>=nums[0]){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return r+1<nums.length?nums[r+1]:nums[0];
    }
}
