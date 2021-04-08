package leetcode;

public class No136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int[] flag = new int[2];
        flag[0] = 1;
        flag[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            ans+=flag[i%2]*nums[i];
        }
        return ans;
    }
}
