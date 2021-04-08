package leetcode;

import java.util.Stack;

public class No1006 {
    public int clumsy(int N) {
        if(N<3) return N;

        Stack<Integer> stack = new Stack<>();
        int symbol_flag = 0, ans=0;
        stack.push(N);
        while (--N>0){
            switch (symbol_flag%4){
                case 0:
                    int t_tmp = stack.pop();
                    t_tmp*=N;
                    stack.push(t_tmp);
                    break;
                case 1:
                    int d_tmp = stack.pop();
                    d_tmp/=N;
                    stack.push(d_tmp);
                    break;
                case 2:
                    stack.push(N);
                    break;
                case 3:
                    stack.push(0-N);
                    break;
            }
            symbol_flag=symbol_flag%4+1;
        }

        while (!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        No1006 obj = new No1006();
        System.out.println(obj.clumsy(4));
    }
}
