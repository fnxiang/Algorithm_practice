package leetcode;

import java.util.ArrayList;
import java.util.List;

class No91{

    /** 回溯方法能够解决，但是在时间和空间上无法满足要求*/
    public int numDecodings(String s) {
        List<String> list = new ArrayList<>();
        int[] ans = new int[1];
        recall(s, s.length(), 0, list, ans);
        return ans[0];
    }

    public void recall(String s, int len, int index, List<String> list, int[] ans){
        if(index==len&&list.size()>0){
            ans[0]++;
        }
        for(int i=index+1;i<=index+2;i++){
            if(i>len) return;
            String sub = s.substring(index, i);
            if(checkString(sub)){
                list.add(sub);
                recall(s, len, i, list, ans);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean checkString(String s){
        if(s.charAt(0)=='0') return false;
        if(Integer.valueOf(s)>26)return false;
        return true;
    }

    public int dpResolve(String s){
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n+1; i++) {
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (1 <= a && a <= 9) dp[i] = dp[i - 1];
            if (10 <= b && b <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No91 obj = new No91();
        System.out.println(obj.numDecodings("226"));
    }
}