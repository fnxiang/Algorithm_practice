package com.fring.string;

public class Str {
    public int strToInt(String str) {
        str = str.trim();
        int ans = 0;
        int index = 0;
        int length = str.length();
        int sign = 1;
        if(length==0)return 0;
        if(str.charAt(index)=='-'||str.charAt(index)=='+'){
            sign=str.charAt(index++)=='-'?-1:1;
        }
        for(;index<length;index++){
            if(str.charAt(index)>='0'&&str.charAt(index)<='9'){
                int digit = str.charAt(index)-'0';
                /** 这里很重要 */
                if(ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&digit>Integer.MAX_VALUE%10)){
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }else{
                    ans = ans*10+digit;
                }
            }else{
                break;
            }
        }
        return sign*ans;
    }

    public String strPlus(String num1, String num2){
        int n1_index = num1.length()-1;
        int n2_index = num2.length()-1;
        StringBuilder ans = new StringBuilder();
        int mod = 0;
        while(n1_index>=0||n2_index>=0){
            int x = n1_index>=0?num1.charAt(n1_index) - '0':0;
            int y = n2_index>=0?num2.charAt(n2_index)-'0':0;
            int tmp = x+y+mod;
            if(tmp>=10){
                mod = tmp/10;
                tmp = tmp%10;
            }else{
                mod = 0;
            }
            ans.append(tmp);

            n1_index--;
            n2_index--;
        }

        if(mod!=0){
            ans.append(mod);
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Str obj = new Str();
        System.out.println(obj.strPlus("111111", "1111111"));
    }
}
