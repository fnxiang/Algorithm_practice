package leetcode;

import java.util.HashMap;

public class No1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int[] plus_nums = new int[dominoes.length];
        int[] time_nums = new int[dominoes.length];
        /** 遍历数组 */
        for (int i=0;i<dominoes.length;i++) {
            plus_nums[i] = dominoes[i][0]+dominoes[i][1];
            time_nums[i] = dominoes[i][0]*dominoes[i][1];
        }

        for(int j=0;j<dominoes.length;j++){
            for (int k=j+1;k<dominoes.length;k++){
                if(plus_nums[j]==plus_nums[k]&time_nums[j]==time_nums[k]) count++;
            }
        }
        return count;
    }
    public int besNumEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        /** 遍历数组 */
        for (int[] domino : dominoes) {
            int num = 0;
            if(domino[0]<domino[1]) num = domino[0]*10+domino[1];
            else num = domino[1]*10+domino[0];
            if(map.get(num)==null) map.put(num, 1);
            else map.put(num, map.get(num)+1);
        }
        /** 存在一个排列组合 */
        for(Integer key: map.keySet()){
            ans+=map.get(key)*(map.get(key)-1)/2;
        }
        return ans;
    }
}
