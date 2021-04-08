package leetcode;

public class No1721 {
    public int trap(int[] height) {
        int n = height.length;
        int l=0, r=n-1;
        int high=1;
        int ans = 0;
        while (l<r){
            //找到左边等于high的索引
            for (int m=l;m<n;m++){
                if(height[m]>=high) {
                    l=m;
                    break;
                }
                l++;
            }
            //找到右边等于high的索引
            for (int k=n-1;k>0;k--){
                if(height[k]>=high){
                    r=k;
                    break;
                }
                r--;
            }

            for(int x=l;x<r;x++){
                    if(height[x]<high) ans++;
            }
            high++;
        }
        return ans;
    }

    /** 99.90% 8%  利用更巧妙的思路去统计*/
    public int sample(int[] height){
        int sum = 0;
        for(int i = 0;i<height.length;i++) {
            sum += height[i];
        }//求数组总和
        int volume = 0; // 总体积和高度初始化
        int high = 1;
        int size = height.length;
        int left = 0; // 双指针初始化
        int right = size - 1;
        while (left <= right) {
            while (left <= right && height[left] < high) {
                left++;
            }
            while (left <= right && height[right] < high) {
                right--;
            }
            volume += right - left + 1; // 每一层的容量都加起来
            high++; // 高度加一
        }
        return volume -sum; // 总体积减去柱子体积，即雨水总量
    }

    public static void main(String[] args) {
        int[] height = new int[12];
        height[0] = 0;
        height[1] = 1;
        height[2] = 0;
        height[3] = 2;
        height[4] = 1;
        height[5] = 0;
        height[6] = 1;
        height[7] = 3;
        height[8] = 2;
        height[9] = 1;
        height[10] = 2;
        height[11] = 1;
//        height[0] = 2;
//        height[1] = 0;
//        height[2] = 2;
        No1721 obj = new No1721();
        System.out.println(obj.trap(height));
    }
}
