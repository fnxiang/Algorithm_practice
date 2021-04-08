package leetcode;

import java.util.*;

public class No90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        dfs(nums, 0, cur, ans);
        return new ArrayList<>(ans);
    }

    public void dfs(int[] nums, int index, List<Integer> cur, Set<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(nums, index+1, cur, ans);

        cur.remove(cur.size()-1);
        dfs(nums, index+1, cur, ans);
    }
}
