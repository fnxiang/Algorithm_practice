package leetcode;

public class strStr {
    /** 最直观的解法 */
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2==0) return 0;
        if(len1<len2) return -1;
        int index_a = 0;
        int index_b = 0;
        int ans = -1;
        for (;index_a<haystack.length();index_a++){
            if(haystack.charAt(index_a)==needle.charAt(index_b)){
                ans = index_a;
                while(index_a+index_b<len1&&index_b<len2&&haystack.charAt(index_b+index_a)==needle.charAt(index_b)){
                    index_b++;
                }
                if(index_b==len2)return ans;
            }
            index_b=0;
        }
        return -1;
    }

    public int KMP(String haystack, String needle){
        int n=haystack.length(), m=needle.length();
        char[] ss = haystack.toCharArray(), s = needle.toCharArray();
        for(int i=0;i<=n-m;i++){
            int a=i, b=0;
            while(b<m&&ss[a]==s[b]){
                b++;
                a++;
            }
            if(b==m) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        strStr obj = new strStr();
        obj.KMP("ab", "ab");
    }
}
