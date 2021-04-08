package leetcode;

public class No724 {
    public int pivotIndex(int[] nums) {
        if (nums.length==0) return -1;
        int[] front_sum = new int[nums.length];
        int[] end_sum = new int[nums.length];
        int f_sum = 0;
        int e_sum = 0;
        for(int i=0;i<nums.length;i++){
            f_sum+=nums[i];
            front_sum[i]=f_sum;
        }

        for(int j=nums.length-1;j>-1;j--){
            e_sum+=nums[j];
            end_sum[j]=e_sum;
        }
        if(end_sum[1]==0||nums.length==1)return 0;
        if(front_sum[nums.length-2]==0&&nums.length!=1) return nums.length-1;
        for(int k=1;k<nums.length-1;k++){
            if(front_sum[k-1]-end_sum[k+1]==0) return k;
        }
        return -1;
    }

    /** 优化 */

    public int bestPivotIndex(int[] nums) {
        int length = nums.length;
        if (length==0)return -1;
        int[] front_sum = new int[length];
        int[] end_sum = new int[length];
        front_sum[0]=0;
        end_sum[length-1]=0;
        for(int i=1;i<nums.length;i++){
            front_sum[i]=front_sum[i-1]+nums[i-1];
        }

        for(int j=nums.length-2;j>-1;j--){
            end_sum[j]=end_sum[j+1]+nums[j+1];
        }

        for(int k=0;k<nums.length;k++){
            if(front_sum[k]==end_sum[k]) return k;
        }
        return -1;
    }
}
