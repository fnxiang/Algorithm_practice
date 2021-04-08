package leetcode;

public class No88_fail {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0) nums1=nums2;
        int i=0, j=0, length = m;
        while (length<m+n){
            if(nums1[i]<nums2[j]){
                i++;
            }else{
                for (int k=length+1;k>i;k--){
                    nums1[k] = nums1[k-1];
                }
                nums1[i]=nums2[j];
                length++;
                j++;
            }
        }
    }
}
