package com.fring.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopK {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            int time = map.get(key);
            if(list[time]==null){
                list[time] = new ArrayList<>();
            }
            list[time].add(key);
        }

        /** 错写成nums.length了 */
        for(int i=list.length-1;ans.size()<k;i++){
            if(list[i]==null) continue;
            ans.addAll(list[i]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
