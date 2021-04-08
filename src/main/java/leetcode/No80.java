package leetcode;

public class No80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3){
            return nums.length;
        }
        int count = 1; //记录每个元素的次数，和前一个不相等则变
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if(nums[i]==nums[i-1]&&count==2){
                for (int j = i; j < length-1; j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                length--;
            }else if(nums[i]!=nums[i-1]){
                count=1;
            }else {
                count++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[9];
        nums[0]=0;
        nums[1]=0;
        nums[2]=1;
        nums[3]=1;
        nums[4]=1;
        nums[5]=1;
        nums[6]=2;
        nums[7]=3;
        nums[8]=3;
        No80 obj = new No80();
        obj.removeDuplicates(nums);
    }
}
