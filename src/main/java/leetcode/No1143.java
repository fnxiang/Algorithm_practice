package leetcode;

public class No1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[m][n];
        char[] c_text1 = text1.toCharArray();
        char[] c_text2 = text2.toCharArray();
        for (int i = 0; i < n; i++) {
            if(c_text1[i]==c_text2[0]||i!=0&&dp[0][i-1]==1){
                dp[0][i] = 1;
            }else {
                dp[0][i] = 0;
            }
        }

        for (int j = 0; j < m; j++) {
            if(c_text1[0]==c_text2[j]||j!=0&&dp[j-1][0]==1){
                dp[j][0] = 1;
            }else {
                dp[j][0] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(c_text1[j]==c_text2[i]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "def";
        No1143 obj = new No1143();
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }
}
