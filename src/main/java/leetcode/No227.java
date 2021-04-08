package leetcode;

import java.util.Stack;

public class No227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0, sign = 1;
        int len = s.length();
        char[] str = s.toCharArray();
        char op = '#';
        for(int i=0;i<len;i++){
            if (str[i] == ' ') continue;
            if(str[i]>='0'&&str[i]<='9'){
                int num = str[i]-'0';
                while(i<len-1&&str[i+1]>='0'&&str[i+1]<='9'){
                    num = num*10 + str[i++]-'0';
                }
                if(op=='#'){
                    if(op=='*') num*=stack.pop();
                    else num = stack.pop()/num;
                    op = '#';
                }
                stack.push(num);
            }
            else if(str[i]=='*'||str[i]=='/'){
                op = str[i];
            }else{
                ans+=stack.pop()*sign;
                sign = str[i]=='+'?1:-1;
            }
        }
        return ans+stack.pop()*sign;
    }
}
