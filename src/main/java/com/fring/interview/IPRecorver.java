package com.fring.interview;

import java.util.*;

public class IPRecorver {
    public List<String> recover(String s){
        int length = s.length();
        List<String> ans = new ArrayList<>();
        if(length<4||length>12) return ans;

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, length, 0, 4, path, ans);
        return ans;
    }

    private void dfs(String s, int length, int index, int time, Deque<String> path, List<String> ans) {
        /** 先找推出条件 */
        if( index==length ){
            if(time==0){
                ans.add(String.join(".",path));
            }
            return;
        }

        for (int i=index;i<index+3;i++){
            if(i>=length) break;

            if(time*3<length-i){
                continue;
            }
            /** 回溯的主体，需要好好理解 */
            if(judgeIP(s, index, i)){
                String cur_ip = s.substring(index, i+1);
                path.addLast(cur_ip);

                dfs(s, length, i+1, time-1, path, ans);
                path.removeLast();
            }
        }
    }

    private boolean judgeIP(String s, int l, int r){
        int length = r-l+1;
        if(length>1&&s.charAt(l)=='0') return false;

        int res = 0;
        while (l<=r){
            res = res*10 + s.charAt(l)-'0';
            l++;
        }

        return  res>=0&&res<=255;
    }
}
